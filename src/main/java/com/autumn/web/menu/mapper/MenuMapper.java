package com.autumn.web.menu.mapper;

import com.autumn.web.menu.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @description 针对表【sys_menu(菜单权限表)】的数据库操作Mapper
 * @createDate 2023-05-31 14:56:54
 * @Entity com.autumn.menu.entity.Menu
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMenuList(String loginId);

    List<Menu> getBtnPermsList(String loginId);

    List<Menu> getMenuBtnsByUserid(Map param);
}




