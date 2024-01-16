package com.autumn.web.dictData.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.autumn.common.result.Result;
import com.autumn.web.dictData.entity.DictDataInsertDto;
import com.autumn.web.dictData.entity.DictDataSelectDto;
import com.autumn.web.dictData.entity.DictDataUpdateDto;
import com.autumn.web.dictData.service.DictDataService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;

/**
 * @author autumn
 * @date 2023-06-13 09:00:38
 * 测试生成表 Controller
 */
@Validated
@RestController
@RequestMapping("/dictData")
public class DictDataController {

    @Resource
    private DictDataService dictDataService;

    /**
     * 测试生成表查询
     */
    @Cacheable(value = "dictData")
    @PostMapping("/select")
    @SaCheckPermission("dictData.select")
    public Result selectDictData(@RequestBody DictDataSelectDto dictDataSelectDto) {
        return dictDataService.selectDictData(dictDataSelectDto);
    }

    /**
     * 测试生成表新增
     */
    @CacheEvict(value = "dictData", allEntries = true)
    @PostMapping("/insert")
    @SaCheckPermission("dictData.insert")
    public Result insertDictData(@RequestBody @Validated DictDataInsertDto dictDataInsertDto) {
        return dictDataService.insertDictData(dictDataInsertDto);
    }

    /**
     * 测试生成表修改
     */
    @CacheEvict(value = "dictData", allEntries = true)
    @PostMapping("/update")
    @SaCheckPermission("dictData.update")
    public Result updateDictData(@RequestBody @Validated DictDataUpdateDto dictDataUpdateDto) {
        return dictDataService.updateDictData(dictDataUpdateDto);
    }

    /**
     * 测试生成表删除
     */
    @CacheEvict(value = "dictData", allEntries = true)
    @GetMapping("/delete")
    @SaCheckPermission("dictData.delete")
    public Result deleteDictData(@RequestParam("ids") @NotBlank(message = "ids不能为空") String ids) {
        return dictDataService.deleteDictData(ids);
    }

    /**
     * 菜单excel导出
     */
    @PostMapping("/export")
    @SaCheckPermission("dictData.export")
    public void exportDictData(@RequestBody DictDataSelectDto dictDataSelectDto, HttpServletResponse response) {
        dictDataService.exportDictData(dictDataSelectDto, response);
    }

    /**
     * 菜单excel导入
     */
    @CacheEvict(value = "dictData", allEntries = true)
    @PostMapping("/import")
    @SaCheckPermission("dictData.import")
    public Result importDictData(MultipartFile file) {
        return dictDataService.importDictData(file);
    }

}
