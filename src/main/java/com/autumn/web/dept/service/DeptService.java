package com.autumn.web.dept.service;

import com.autumn.common.result.Result;
import com.autumn.web.dept.entity.Dept;
import com.autumn.web.dept.entity.DeptInsertDto;
import com.autumn.web.dept.entity.DeptSelectDto;
import com.autumn.web.dept.entity.DeptUpdateDto;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author lqz
 * @date 2023-07-09 16:13:26
 * 部门信息 Service
 */
public interface DeptService extends IService<Dept> {

    /**
     * 部门信息查询
     */
    Result selectDept(DeptSelectDto deptSelectDto);

    /**
     * 部门信息新增
     */
    Result insertDept(DeptInsertDto deptInsertDto);

    /**
     * 部门信息修改
     */
    Result updateDept(DeptUpdateDto deptUpdateDto);

    /**
     * 部门信息删除
     */
    Result deleteDept(String ids);

    /**
     * 部门信息excel导出
     */
    void exportDept(DeptSelectDto deptSelectDto, HttpServletResponse response);

    /**
     * 部门信息excel导入
     */
    Result importDept(MultipartFile file);

    /**
     * 所属部门下拉数据
     */
    Result getDeptList(DeptSelectDto deptSelectDto);
}
