package com.autumn.web.role.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson2.JSON;
import com.autumn.common.dictionary.Dictionary;
import com.autumn.common.easyExcel.CustomRowHeightColWidthHandler;
import com.autumn.common.easyExcel.RowHeightColWidthModel;
import com.autumn.common.easyExcel.listener.ImportExcelListener;
import com.autumn.common.page.ResData;
import com.autumn.common.publicEntity.LabelValue;
import com.autumn.common.result.Result;
import com.autumn.web.role.entity.Role;
import com.autumn.web.role.entity.RoleInsertDto;
import com.autumn.web.role.entity.RoleSelectDto;
import com.autumn.web.role.entity.RoleUpdateDto;
import com.autumn.web.role.mapper.RoleMapper;
import com.autumn.web.role.service.RoleService;
import com.autumn.web.roleMenu.entity.RoleMenu;
import com.autumn.web.roleMenu.mapper.RoleMenuMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lqz
 * @date 2023-07-09 19:34:33
 * 角色信息 ServiceImpl
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleService roleService;
    @Resource
    private RoleMenuMapper roleMenuMapper;

    /**
     * 角色信息查询
     */
    @Override
    public Result selectRole(RoleSelectDto roleSelectDto) {
        Page<Role> page = PageHelper.startPage(roleSelectDto.getPageNum(), roleSelectDto.getPageSize());
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<Role>().like(!StringUtils.isEmpty(roleSelectDto.getRoleName()), Role::getRoleName, "%" + roleSelectDto.getRoleName() + "%").like(!StringUtils.isEmpty(roleSelectDto.getRoleKey()), Role::getRoleKey, "%" + roleSelectDto.getRoleKey() + "%").eq(!StringUtils.isEmpty(roleSelectDto.getStatus()), Role::getStatus, roleSelectDto.getStatus()).orderByDesc(Role::getCreateTime);
        List<Role> roleList = roleMapper.selectList(queryWrapper);
        List<Map> list = new ArrayList<>();
        for (Role role : roleList) {
            Map map = JSON.parseObject(JSON.toJSONString(role), Map.class);
            LambdaQueryWrapper<RoleMenu> wrapper = new LambdaQueryWrapper<RoleMenu>().eq(RoleMenu::getRoleId, role.getId());
            List<RoleMenu> roleMenus = roleMenuMapper.selectList(wrapper);
            List<String> menuIds = roleMenus.stream().map(m -> {
                return m.getMenuId();
            }).collect(Collectors.toList());
            map.put("menuTreeList", menuIds);
            list.add(map);
        }
        return ResData.setDataTotal(page, list);
    }

    /**
     * 角色信息新增
     */
    @Transactional
    @Override
    public Result insertRole(RoleInsertDto roleInsertDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleInsertDto, role);
        //新增主表
        int i = roleMapper.insert(role);
        //新增子表
        List<String> menuTreeList = roleInsertDto.getMenuTreeList();
        if (!CollectionUtils.isEmpty(menuTreeList)) {
            for (String s : menuTreeList) {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setMenuId(s);
                roleMenu.setRoleId(role.getId());
                roleMenuMapper.insert(roleMenu);
            }
        }
        return i > 0 ? Result.success() : Result.fail();
    }

    /**
     * 角色信息修改
     */
    @Transactional
    @Override
    public Result updateRole(RoleUpdateDto roleUpdateDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleUpdateDto, role);
        //修改主表
        int i = roleMapper.updateById(role);
        //修改子表
        List<String> menuTreeList = roleUpdateDto.getMenuTreeList();
        if (!CollectionUtils.isEmpty(menuTreeList)) {
            //查询原来数据集
            LambdaQueryWrapper<RoleMenu> wrapper = new LambdaQueryWrapper<RoleMenu>().eq(RoleMenu::getRoleId, role.getId());
            List<RoleMenu> roleMenus = roleMenuMapper.selectList(wrapper);
            List<String> menuIds = roleMenus.stream().map(m -> {
                return m.getMenuId();
            }).collect(Collectors.toList());
            List<String> differenceIds = Stream.concat(menuIds.stream().filter(str -> !menuTreeList.contains(str)), menuTreeList.stream().filter(str -> !menuIds.contains(str))).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(differenceIds)) {
                for (String s : differenceIds) {
                    RoleMenu roleMenu = new RoleMenu();
                    roleMenu.setMenuId(s);
                    roleMenu.setRoleId(role.getId());
                    LambdaQueryWrapper<RoleMenu> wrapper1 = new LambdaQueryWrapper<RoleMenu>().eq(RoleMenu::getRoleId, role.getId()).eq(RoleMenu::getMenuId, s);
                    RoleMenu selectOne = roleMenuMapper.selectOne(wrapper1);
                    if (selectOne == null) {
                        roleMenuMapper.insert(roleMenu);
                    } else {
                        roleMenuMapper.deleteById(selectOne.getId());
                    }
                }
            }
        } else {
            LambdaQueryWrapper<RoleMenu> wrapper = new LambdaQueryWrapper<RoleMenu>().eq(RoleMenu::getRoleId, role.getId());
            RoleMenu selectOne = roleMenuMapper.selectOne(wrapper);
            roleMenuMapper.deleteById(selectOne.getId());
        }
        return i > 0 ? Result.success() : Result.fail();
    }

    /**
     * 角色信息删除
     */
    @Transactional
    @Override
    public Result deleteRole(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        //删除主表
        int i = roleMapper.deleteBatchIds(idList);
        //删除子表
        for (String id : idList) {
            LambdaQueryWrapper<RoleMenu> wrapper = new LambdaQueryWrapper<RoleMenu>().eq(RoleMenu::getRoleId, id);
            roleMenuMapper.delete(wrapper);
        }
        return i > 0 ? Result.success() : Result.fail();
    }

    /**
     * 角色信息excel导出
     */
    @Override
    public void exportRole(RoleSelectDto roleSelectDto, HttpServletResponse response) {
        List<Role> list = new ArrayList<>();
        if (!roleSelectDto.getTempFlag()) {
            LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<Role>().orderByAsc(Role::getRoleSort);
            list = roleMapper.selectList(queryWrapper);
        }
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        try {
            String sheetName = "角色信息";
            // 这里URLEncoder.encode可以防止中文乱码
            String fileName = URLEncoder.encode(sheetName + "列表", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            List<RowHeightColWidthModel> rowHeightColWidthList = new ArrayList<>();
            //隐藏列
            rowHeightColWidthList.add(RowHeightColWidthModel.createHideColModel(sheetName, 0));
            EasyExcel.write(response.getOutputStream(), Role.class).sheet(sheetName).registerWriteHandler(new CustomRowHeightColWidthHandler(rowHeightColWidthList)).doWrite(list);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * 角色信息excel导入
     */
    @Override
    public Result importRole(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(), Role.class, new ImportExcelListener<Role>(roleService)).sheet("岗位信息").doRead();
        } catch (Exception e) {
            e.getMessage();
        }
        return Result.success();
    }

    /**
     * 获取所属角色下拉数据
     */
    @Override
    public Result getRoleList(RoleSelectDto roleSelectDto) {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<Role>()
                .eq(Role::getStatus, Dictionary.NO)
                .orderByDesc(Role::getCreateTime);
        List<Role> roleList = roleMapper.selectList(queryWrapper);
        List<LabelValue> list = new ArrayList<>();
        if (!CollectionUtils.isEmpty(roleList)) {
            for (Role role : roleList) {
                LabelValue labelValue = new LabelValue();
                labelValue.setLabel(role.getRoleName());
                labelValue.setValue(role.getId());
                list.add(labelValue);
            }
        }
        return Result.successData(list);
    }

}
