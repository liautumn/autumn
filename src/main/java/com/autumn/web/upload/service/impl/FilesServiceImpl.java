package com.autumn.web.upload.service.impl;

import com.autumn.common.page.ResData;
import com.autumn.common.result.Result;
import com.autumn.web.upload.entity.Files;
import com.autumn.web.upload.entity.FilesInsertDto;
import com.autumn.web.upload.entity.FilesSelectDto;
import com.autumn.web.upload.entity.FilesUpdateDto;
import com.autumn.web.upload.mapper.FilesMapper;
import com.autumn.web.upload.service.FilesService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author autumn
 * @date 2023-06-12 09:18:53
 * 测试生成表 ServiceImpl
 */
@Service
public class FilesServiceImpl extends ServiceImpl<FilesMapper, Files> implements FilesService {

    @Resource
    private FilesMapper filesTypeMapper;

    /**
     * 测试生成表查询
     */
    @Override
    public Result selectFiles(FilesSelectDto filesTypeSelectDto) {
        Page<Files> page = PageHelper.startPage(filesTypeSelectDto.getPageNum(), filesTypeSelectDto.getPageSize());
        LambdaQueryWrapper<Files> queryWrapper = new LambdaQueryWrapper<Files>()
                .orderByDesc(Files::getCreateTime);
        List<Files> filesTypeList = filesTypeMapper.selectList(queryWrapper);
        return ResData.setDataTotal(page, filesTypeList);
    }

    /**
     * 测试生成表新增
     */
    @Override
    public Result insertFiles(FilesInsertDto filesTypeInsertDto) {
        Files filesType = new Files();
        BeanUtils.copyProperties(filesTypeInsertDto, filesType);
        int i = filesTypeMapper.insert(filesType);
        return i > 0 ? Result.successData(filesType) : Result.fail();
    }

    /**
     * 测试生成表修改
     */
    @Override
    public Result updateFiles(FilesUpdateDto filesTypeUpdateDto) {
        Files filesType = new Files();
        BeanUtils.copyProperties(filesTypeUpdateDto, filesType);
        int i = filesTypeMapper.updateById(filesType);
        return i > 0 ? Result.success() : Result.fail();
    }

    /**
     * 测试生成表删除
     */
    @Override
    public Result deleteFiles(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        int i = filesTypeMapper.deleteBatchIds(idList);
        return i > 0 ? Result.success() : Result.fail();
    }
}
