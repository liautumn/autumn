package com.autumn.web.menu.controller;

import com.autumn.common.result.Result;
import com.autumn.web.menu.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/buttons")
public class BtnController {

    @Resource
    private MenuService menuService;

    @GetMapping
    public Result getBtnsList() {
        return menuService.getBtnsList();
    }

}
