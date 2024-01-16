package com.autumn.web.menu.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.autumn.common.result.Result;
import com.autumn.web.menu.entity.MenuInsertDto;
import com.autumn.web.menu.entity.MenuSelectDto;
import com.autumn.web.menu.entity.MenuTreeDto;
import com.autumn.web.menu.entity.MenuUpdateDto;
import com.autumn.web.menu.service.MenuService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;

/**
 * 菜单管理
 */
@Validated
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    /**
     * 获取个人菜单路由列表
     *
     * @return
     */
    @GetMapping("/list")
    public Result getMenuList() {
        return menuService.getMenuList();
    }

    /**
     * 菜单查询
     */
    @PostMapping("/select")
    @SaCheckPermission("menu.select")
    public Result selectMenu(@RequestBody MenuSelectDto menuSelectDto) {
        return menuService.selectMenu(menuSelectDto);
    }

    /**
     * 菜单树列表数据
     */
    @PostMapping("/getMenuTree")
    public Result getMenuTree(@RequestBody MenuTreeDto menuTreeDto) {
        return menuService.getMenuTree(menuTreeDto);
    }

    /**
     * 菜单新增
     */
    @PostMapping("/insert")
    @SaCheckPermission("menu.insert")
    public Result insertMenu(@RequestBody @Validated MenuInsertDto menuInsertDto) {
        return menuService.insertMenu(menuInsertDto);
    }

    /**
     * 菜单修改
     */
    @PostMapping("/update")
    @SaCheckPermission("menu.update")
    public Result updateMenu(@RequestBody @Validated MenuUpdateDto menuUpdateDto) {
        return menuService.updateMenu(menuUpdateDto);
    }

    /**
     * 菜单删除
     */
    @GetMapping("/delete")
    @SaCheckPermission("menu.delete")
    public Result deleteMenu(@RequestParam("ids") @NotBlank(message = "ids不能为空") String ids) {
        return menuService.deleteMenu(ids);
    }

    /**
     * 菜单excel导出
     */
    @PostMapping("/export")
    @SaCheckPermission("menu.export")
    public void exportMenu(@RequestBody MenuSelectDto menuSelectDto, HttpServletResponse response) {
        menuService.exportMenu(menuSelectDto, response);
    }

    /**
     * 菜单excel导入
     */
    @PostMapping("/import")
    @SaCheckPermission("menu.import")
    public Result importMenu(MultipartFile file) {
        return menuService.importMenu(file);
    }

}
