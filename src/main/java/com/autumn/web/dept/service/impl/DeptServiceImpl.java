package com.autumn.web.dept.service.impl;


import com.alibaba.excel.EasyExcel;
import com.autumn.common.dictionary.Dictionary;
import com.autumn.common.easyExcel.CustomRowHeightColWidthHandler;
import com.autumn.common.easyExcel.RowHeightColWidthModel;
import com.autumn.common.easyExcel.listener.ImportExcelListener;
import com.autumn.common.page.ResData;
import com.autumn.common.publicEntity.LabelValue;
import com.autumn.common.result.Result;
import com.autumn.common.tree.TreeUtil;
import com.autumn.web.dept.entity.Dept;
import com.autumn.web.dept.entity.DeptInsertDto;
import com.autumn.web.dept.entity.DeptSelectDto;
import com.autumn.web.dept.entity.DeptUpdateDto;
import com.autumn.web.dept.mapper.DeptMapper;
import com.autumn.web.dept.service.DeptService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lqz
 * @date 2023-07-09 16:13:26
 * 部门信息 ServiceImpl
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

    @Resource
    private DeptMapper deptMapper;
    @Resource
    private DeptService deptService;

    /**
     * 部门信息查询
     */
    @Override
    public Result selectDept(DeptSelectDto deptSelectDto) {
        Page<Dept> page = PageHelper.startPage(deptSelectDto.getPageNum(), deptSelectDto.getPageSize());
        LambdaQueryWrapper<Dept> queryWrapper = new LambdaQueryWrapper<Dept>()
                .orderByAsc(Dept::getOrderNum);
        List<Dept> deptList = deptMapper.selectList(queryWrapper);
        //转树
        List tree = TreeUtil.buildTree(deptList);
        return ResData.setDataTotal(page, tree);
    }

    /**
     * 部门信息新增
     */
    @Override
    public Result insertDept(DeptInsertDto deptInsertDto) {
        Dept dept = new Dept();
        BeanUtils.copyProperties(deptInsertDto, dept);
        int i = deptMapper.insert(dept);
        return i > 0 ? Result.success() : Result.fail();
    }

    /**
     * 部门信息修改
     */
    @Override
    public Result updateDept(DeptUpdateDto deptUpdateDto) {
        Dept dept = new Dept();
        BeanUtils.copyProperties(deptUpdateDto, dept);
        int i = deptMapper.updateById(dept);
        return i > 0 ? Result.success() : Result.fail();
    }

    /**
     * 部门信息删除
     */
    @Override
    public Result deleteDept(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        int i = deptMapper.deleteBatchIds(idList);
        return i > 0 ? Result.success() : Result.fail();
    }

    /**
     * 部门信息excel导出
     */
    @Override
    public void exportDept(DeptSelectDto deptSelectDto, HttpServletResponse response) {
        List<Dept> list = new ArrayList<>();
        if (!deptSelectDto.getTempFlag()) {
            LambdaQueryWrapper<Dept> queryWrapper = new LambdaQueryWrapper<Dept>()
                    .orderByDesc(Dept::getCreateTime);
            list = deptMapper.selectList(queryWrapper);
        }
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        try {
            String sheetName = "部门信息";
            // 这里URLEncoder.encode可以防止中文乱码
            String fileName = URLEncoder.encode(sheetName + "列表", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            List<RowHeightColWidthModel> rowHeightColWidthList = new ArrayList<>();
            //隐藏列
            rowHeightColWidthList.add(RowHeightColWidthModel.createHideColModel(sheetName, 0));
            EasyExcel.write(response.getOutputStream(), Dept.class)
                    .sheet(sheetName)
                    .registerWriteHandler(new CustomRowHeightColWidthHandler(rowHeightColWidthList))
                    .doWrite(list);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * 部门信息excel导入
     */
    @Override
    public Result importDept(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(), Dept.class, new ImportExcelListener<Dept>(deptService)).sheet("岗位信息").doRead();
        } catch (Exception e) {
            e.getMessage();
        }
        return Result.success();
    }

    /**
     * 所属部门下拉数据
     */
    @Override
    public Result getDeptList(DeptSelectDto deptSelectDto) {
        LambdaQueryWrapper<Dept> queryWrapper = new LambdaQueryWrapper<Dept>()
                .eq(Dept::getStatus, Dictionary.NO)
                .orderByDesc(Dept::getCreateTime);
        List<Dept> deptList = deptMapper.selectList(queryWrapper);
        List<LabelValue> list = new ArrayList<>();
        if (!CollectionUtils.isEmpty(deptList)) {
            for (Dept dept : deptList) {
                LabelValue labelValue = new LabelValue();
                labelValue.setId(dept.getId());
                labelValue.setParentId(dept.getParentId());
                labelValue.setLabel(dept.getDeptName());
                labelValue.setValue(dept.getId());
                list.add(labelValue);
            }
        }
        List treeList = TreeUtil.buildTree(list);
        if (deptSelectDto.getIsGetRoot()) {
            LabelValue labelValue = new LabelValue();
            labelValue.setId(Dictionary.ROOTID);
            labelValue.setLabel(Dictionary.ROOTTITLE);
            labelValue.setValue(Dictionary.ROOTID);
            treeList.add(0, labelValue);
        }
        return Result.successData(treeList);
    }

}
