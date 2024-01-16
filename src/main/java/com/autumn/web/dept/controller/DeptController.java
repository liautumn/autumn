package com.autumn.web.dept.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.autumn.common.result.Result;
import com.autumn.web.dept.entity.DeptInsertDto;
import com.autumn.web.dept.entity.DeptSelectDto;
import com.autumn.web.dept.entity.DeptUpdateDto;
import com.autumn.web.dept.service.DeptService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;

/**
 * @author lqz
 * @date 2023-07-09 16:13:26
 * 部门信息 Controller
 */
@Validated
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Resource
    private DeptService deptService;

    /**
     * 部门信息查询
     */
    @PostMapping("/select")
    @SaCheckPermission("dept.select")
    public Result selectDept(@RequestBody DeptSelectDto deptSelectDto) {
        return deptService.selectDept(deptSelectDto);
    }

    /**
     * 所属部门下拉数据
     */
    @PostMapping("/getDeptList")
    public Result getDeptList(@RequestBody DeptSelectDto deptSelectDto) {
        return deptService.getDeptList(deptSelectDto);
    }

    /**
     * 部门信息新增
     */
    @PostMapping("/insert")
    @SaCheckPermission("dept.insert")
    public Result insertDept(@RequestBody @Validated DeptInsertDto deptInsertDto) {
        return deptService.insertDept(deptInsertDto);
    }

    /**
     * 部门信息修改
     */
    @PostMapping("/update")
    @SaCheckPermission("dept.update")
    public Result updateDept(@RequestBody @Validated DeptUpdateDto deptUpdateDto) {
        return deptService.updateDept(deptUpdateDto);
    }

    /**
     * 部门信息删除
     */
    @GetMapping("/delete")
    @SaCheckPermission("dept.delete")
    public Result deleteDept(@RequestParam("ids") @NotBlank(message = "ids不能为空") String ids) {
        return deptService.deleteDept(ids);
    }

    /**
     * 部门信息excel导出
     */
    @PostMapping("/export")
    @SaCheckPermission("dept.export")
    public void exportDept(@RequestBody DeptSelectDto deptSelectDto, HttpServletResponse response) {
        deptService.exportDept(deptSelectDto, response);
    }

    /**
     * 部门信息excel导入
     */
    @PostMapping("/import")
    @SaCheckPermission("dept.import")
    public Result importDept(MultipartFile file) {
        return deptService.importDept(file);
    }

}
