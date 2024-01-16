package com.autumn.web.dictType.service.impl;

import com.alibaba.excel.EasyExcel;
import com.autumn.common.easyExcel.CustomRowHeightColWidthHandler;
import com.autumn.common.easyExcel.RowHeightColWidthModel;
import com.autumn.common.easyExcel.listener.ImportExcelListener;
import com.autumn.common.page.ResData;
import com.autumn.common.result.Result;
import com.autumn.web.dictData.entity.DictData;
import com.autumn.web.dictData.mapper.DictDataMapper;
import com.autumn.web.dictType.entity.DictType;
import com.autumn.web.dictType.entity.DictTypeInsertDto;
import com.autumn.web.dictType.entity.DictTypeSelectDto;
import com.autumn.web.dictType.entity.DictTypeUpdateDto;
import com.autumn.web.dictType.mapper.DictTypeMapper;
import com.autumn.web.dictType.service.DictTypeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * @description 针对表【sys_dict_type(字典类型表)】的数据库操作Service实现
 * @createDate 2023-06-10 14:58:48
 */
@Service
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {

    @Resource
    private DictTypeMapper dictTypeMapper;
    @Resource
    private DictDataMapper dictDataMapper;
    @Resource
    private DictTypeService dictTypeService;

    @Override
    public Result selectDictType(DictTypeSelectDto dictTypeSelectDto) {
        Page<DictType> page = PageHelper.startPage(dictTypeSelectDto.getPageNum(), dictTypeSelectDto.getPageSize());
        LambdaQueryWrapper<DictType> queryWrapper = new LambdaQueryWrapper<DictType>()
                .like(!StringUtils.isEmpty(dictTypeSelectDto.getDictName()), DictType::getDictName, "%" + dictTypeSelectDto.getDictName() + "%")
                .like(!StringUtils.isEmpty(dictTypeSelectDto.getDictType()), DictType::getDictType, "%" + dictTypeSelectDto.getDictType() + "%")
                .eq(!StringUtils.isEmpty(dictTypeSelectDto.getStatus()), DictType::getStatus, dictTypeSelectDto.getStatus())
                .orderByDesc(DictType::getCreateTime);
        List<DictType> dictTypeList = dictTypeMapper.selectList(queryWrapper);
        return ResData.setDataTotal(page, dictTypeList);
    }

    @Override
    public Result insertDictType(DictTypeInsertDto dictTypeInsertDto) {
        DictType dictType = new DictType();
        BeanUtils.copyProperties(dictTypeInsertDto, dictType);
        int i = dictTypeMapper.insert(dictType);
        return i > 0 ? Result.success() : Result.fail();
    }

    @Override
    public Result updateDictType(DictTypeUpdateDto dictTypeUpdateDto) {
        DictType dictType = new DictType();
        BeanUtils.copyProperties(dictTypeUpdateDto, dictType);
        int i = dictTypeMapper.updateById(dictType);
        return i > 0 ? Result.success() : Result.fail();
    }

    @Override
    public Result deleteDictType(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        int i = dictTypeMapper.deleteBatchIds(idList);
        return i > 0 ? Result.success() : Result.fail();
    }

    @Override
    public Result parseDictType(String dictType) {
        LambdaQueryWrapper<DictData> queryWrapper = new LambdaQueryWrapper<DictData>()
                .eq(DictData::getDictType, dictType)
                .orderByAsc(DictData::getDictSort);
        List<DictData> dictData = dictDataMapper.selectList(queryWrapper);
        List data = new ArrayList();
        if (!CollectionUtils.isEmpty(dictData)) {
            for (DictData dict : dictData) {
                HashMap map = new HashMap();
                map.put("label", dict.getDictLabel());
                map.put("value", dict.getDictValue());
                data.add(map);
            }
        }
        return Result.successData(data);
    }

    @Override
    public void exportDictType(DictTypeSelectDto dictTypeSelectDto, HttpServletResponse response) {
        List<DictType> dictTypes = new ArrayList<>();
        if (!dictTypeSelectDto.getTempFlag()) {
            LambdaQueryWrapper<DictType> queryWrapper = new LambdaQueryWrapper<DictType>()
                    .orderByDesc(DictType::getCreateTime);
            dictTypes = dictTypeMapper.selectList(queryWrapper);
        }
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        try {
            String sheetName = "字典类型";
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode(sheetName + "列表", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            List<RowHeightColWidthModel> rowHeightColWidthList = new ArrayList<>();
            //隐藏列
            rowHeightColWidthList.add(RowHeightColWidthModel.createHideColModel(sheetName, 0));
            EasyExcel.write(response.getOutputStream(), DictType.class)
                    .sheet(sheetName)
                    .registerWriteHandler(new CustomRowHeightColWidthHandler(rowHeightColWidthList))
                    .doWrite(dictTypes);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public Result importDictType(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(), DictType.class, new ImportExcelListener<DictType>(dictTypeService)).sheet("字典类型").doRead();
        } catch (Exception e) {
            e.getMessage();
        }
        return Result.success();
    }
}




