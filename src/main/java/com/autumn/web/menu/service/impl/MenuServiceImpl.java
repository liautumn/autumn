package com.autumn.web.menu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson2.JSON;
import com.autumn.common.dictionary.Dictionary;
import com.autumn.common.easyExcel.CustomRowHeightColWidthHandler;
import com.autumn.common.easyExcel.RowHeightColWidthModel;
import com.autumn.common.easyExcel.listener.ImportExcelListener;
import com.autumn.common.publicEntity.LabelValue;
import com.autumn.common.redis.RedisUtil;
import com.autumn.common.result.Result;
import com.autumn.common.saToken.LoginInfoData;
import com.autumn.common.saToken.StpInterfaceImpl;
import com.autumn.common.tree.TreeUtil;
import com.autumn.web.menu.entity.*;
import com.autumn.web.menu.mapper.MenuMapper;
import com.autumn.web.menu.service.MenuService;
import com.autumn.web.role.entity.Role;
import com.autumn.web.role.mapper.RoleMapper;
import com.autumn.web.user.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @description 针对表【sys_menu(菜单权限表)】的数据库操作Service实现
 * @createDate 2023-05-31 14:56:54
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Resource
    private MenuMapper menuMapper;
    @Resource
    private MenuService menuService;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private StpInterfaceImpl stpInterface;

    @Override
    public Result getMenuList() {
        //获取当前用户id
        User userInfo = LoginInfoData.getUserInfo();
        if (userInfo == null) {
            return Result.failMsg("当前用户为空");
        }
        List<Menu> list;
        if (Dictionary.ADMINFLAG.equals(userInfo.getUserType())) {
            LambdaQueryWrapper queryWrapper = new LambdaQueryWrapper<Menu>().eq(Menu::getStatus, Dictionary.NO).orderByAsc(Menu::getOrderNum);
            list = menuMapper.selectList(queryWrapper);
        } else {
            list = menuMapper.getMenuList(userInfo.getId());
        }

        List<MenuVo> menuVoList = new ArrayList<>();
        for (Menu menu : list) {
            MenuVo menuVo = new MenuVo();
            BeanUtils.copyProperties(menu, menuVo);
            Meta meta = new Meta();
            meta.setIcon(menu.getIcon());
            meta.setTitle(menu.getTitle());
            meta.setActiveMenu(menu.getActiveMenu());
            meta.setIsLink(menu.getIsLink().equals(Dictionary.YES) ? menu.getPath() : null);
            meta.setIsHide(menu.getIsHide().equals(Dictionary.YES) ? true : false);
            meta.setIsFull(menu.getIsFull().equals(Dictionary.YES) ? true : false);
            meta.setIsAffix(menu.getIsAffix().equals(Dictionary.YES) ? true : false);
            meta.setIsKeepAlive(menu.getIsKeepAlive().equals(Dictionary.YES) ? true : false);
            menuVo.setMeta(meta);
            menuVoList.add(menuVo);
        }
        //转树
        List treeList = TreeUtil.buildTree(menuVoList);
        return Result.successData(treeList);
    }

    @Override
    public Result getBtnsList() {
        User userInfo = LoginInfoData.getUserInfo();
        String loginId = userInfo.getId();
        //判断是否是管理员
        List<Menu> menuList;
        if (Dictionary.ADMINFLAG.equals(userInfo.getUserType())) {
            LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<Menu>().eq(Menu::getStatus, Dictionary.NO).eq(Menu::getMenuType, Dictionary.MENU);
            menuList = menuMapper.selectList(queryWrapper);
        } else {
            Map param = new HashMap();
            param.put("loginId", loginId);
            param.put("menuType", Dictionary.MENU);
            menuList = menuMapper.getMenuBtnsByUserid(param);
        }
        Map res = new HashMap();
        if (!CollectionUtils.isEmpty(menuList)) {
            for (Menu menu : menuList) {
                List<Menu> btns;
                if (Dictionary.ADMINFLAG.equals(userInfo.getUserType())) {
                    LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<Menu>().eq(Menu::getStatus, Dictionary.NO).eq(Menu::getParentId, menu.getId()).eq(Menu::getMenuType, Dictionary.BUTTEN);
                    btns = menuMapper.selectList(queryWrapper);
                } else {
                    Map map = new HashMap();
                    map.put("loginId", loginId);
                    map.put("menuType", Dictionary.BUTTEN);
                    map.put("parentId", menu.getId());
                    btns = menuMapper.getMenuBtnsByUserid(map);
                }
                Menu me = new Menu();
                me.setPerms(menu.getPerms());
                btns.add(menu);
                List<String> perms = btns.stream().map(m -> m.getPerms()).collect(Collectors.toList());
                res.put(menu.getName(), perms);
            }
        }
        //数据格式转化
        Set<String> keySet = res.keySet();
        List<String> prems = new ArrayList<>();
        for (String key : keySet) {
            List<String> perms = (List<String>) res.get(key);
            if (!CollectionUtils.isEmpty(perms)) {
                for (String perm : perms) {
                    prems.add(key + "." + perm);
                }
            }
        }
        //清空redis
        String premKey = Dictionary.SYSTEM + ":" + Dictionary.PERMS + ":" + LoginInfoData.getUserInfo().getId();
        redisUtil.remove(premKey);
        //存入redis
        redisUtil.set(premKey, JSON.toJSONString(prems));
        //更新sa-token权限数据
        stpInterface.getPermissionList(LoginInfoData.getUserInfo().getId(), null);

        //角色权限处理
        String roleKey = Dictionary.SYSTEM + ":" + Dictionary.ROLES + ":" + LoginInfoData.getUserInfo().getId();
        //清空redis
        redisUtil.remove(roleKey);
        //判断是否管理员
        List<Role> roleList;
        if (Dictionary.ADMINFLAG.equals(userInfo.getUserType())) {
            LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<Role>().eq(Role::getStatus, Dictionary.NO);
            roleList = roleMapper.selectList(queryWrapper);
        } else {
            roleList = roleMapper.getRoleKeysByLoginId(LoginInfoData.getUserInfo().getId());
        }
        List<String> roles = new ArrayList<>();
        if (!CollectionUtils.isEmpty(roleList)) {
            roles = roleList.stream().map(m -> m.getRoleKey()).collect(Collectors.toList());
        }
        //存入redis
        redisUtil.set(roleKey, JSON.toJSONString(roles));
        //更新sa-token权限数据
        stpInterface.getRoleList(LoginInfoData.getUserInfo().getId(), null);
        return Result.successData(res);
    }

    @Override
    public Result selectMenu(MenuSelectDto menuSelectDto) {
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<Menu>().like(!StringUtils.isEmpty(menuSelectDto.getTitle()), Menu::getTitle, "%" + menuSelectDto.getTitle() + "%").eq(!StringUtils.isEmpty(menuSelectDto.getStatus()), Menu::getStatus, menuSelectDto.getStatus()).orderByAsc(Menu::getOrderNum);
        List<Menu> menus = menuMapper.selectList(queryWrapper);
        //转树
        List tree = TreeUtil.buildTree(menus);
        return Result.successData(tree);
    }

    @Override
    public Result insertMenu(MenuInsertDto menuInsertDto) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuInsertDto, menu);
        if (!Dictionary.BUTTEN.equals(menuInsertDto.getMenuType())) {
            String path = menu.getPath();
            String name = path.substring(path.lastIndexOf("/") + 1, path.length());
            menu.setName(name);
        }
        if (Dictionary.BUTTEN.equals(menuInsertDto.getMenuType())) {
            menu.setIsHide(Dictionary.YES);
        }
        int i = menuMapper.insert(menu);
        return i > 0 ? Result.success() : Result.fail();
    }

    @Override
    public Result updateMenu(MenuUpdateDto menuUpdateDto) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuUpdateDto, menu);
        if (!Dictionary.BUTTEN.equals(menu.getMenuType())) {
            String path = menu.getPath();
            String name = path.substring(path.lastIndexOf("/") + 1, path.length());
            menu.setName(name);
        }
        int i = menuMapper.updateById(menu);
        return i > 0 ? Result.success() : Result.fail();
    }

    @Override
    public Result deleteMenu(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        int i = menuMapper.deleteBatchIds(idList);
        return i > 0 ? Result.success() : Result.fail();
    }

    @Override
    public void exportMenu(MenuSelectDto menuSelectDto, HttpServletResponse response) {
        List<Menu> menus = new ArrayList<>();
        if (!menuSelectDto.getTempFlag()) {
            LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<Menu>().orderByAsc(Menu::getOrderNum);
            menus = menuMapper.selectList(queryWrapper);
        }
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        try {
            String sheetName = "菜单";
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode(sheetName + "列表", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

            List<RowHeightColWidthModel> rowHeightColWidthList = new ArrayList<>();
            //隐藏列
            rowHeightColWidthList.add(RowHeightColWidthModel.createHideColModel(sheetName, 0));

            EasyExcel.write(response.getOutputStream(), Menu.class).sheet(sheetName).registerWriteHandler(new CustomRowHeightColWidthHandler(rowHeightColWidthList)).doWrite(menus);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public Result importMenu(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(), Menu.class, new ImportExcelListener<Menu>(menuService)).sheet("菜单").doRead();
        } catch (Exception e) {
            e.getMessage();
        }
        return Result.success();
    }

    @Override
    public Result getMenuTree(MenuTreeDto menuTreeDto) {
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<Menu>().in(!CollectionUtils.isEmpty(menuTreeDto.getMenuType()), Menu::getMenuType, menuTreeDto.getMenuType()).eq(!StringUtils.isEmpty(menuTreeDto.getIsHide()), Menu::getIsHide, menuTreeDto.getIsHide()).eq(!StringUtils.isEmpty(menuTreeDto.getStatus()), Menu::getStatus, menuTreeDto.getStatus()).orderByAsc(Menu::getOrderNum);
        List<Menu> menus = menuMapper.selectList(queryWrapper);
        List<LabelValue> labelValueList = new ArrayList<>();
        for (Menu menu : menus) {
            LabelValue labelValue = new LabelValue();
            labelValue.setId(menu.getId());
            labelValue.setParentId(menu.getParentId());
            labelValue.setLabel(menu.getTitle());
            labelValue.setValue(menu.getId());
            labelValueList.add(labelValue);
        }
        List<LabelValue> treeList = (List<LabelValue>) TreeUtil.buildTree(labelValueList);
        if (menuTreeDto.getIsGetRoot()) {
            LabelValue labelValue = new LabelValue();
            labelValue.setId(Dictionary.ROOTID);
            labelValue.setLabel(Dictionary.ROOTTITLE);
            labelValue.setValue(Dictionary.ROOTID);
            treeList.add(0, labelValue);
        }
        return Result.successData(treeList);
    }

}




