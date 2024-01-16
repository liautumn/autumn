package com.autumn.common.easyExcel.converter;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.autumn.common.springConfig.StaticMethodGetBean;
import com.autumn.web.dictData.entity.DictData;
import com.autumn.web.dictData.mapper.DictDataMapper;
import com.autumn.web.dictType.entity.DictType;
import com.autumn.web.dictType.mapper.DictTypeMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 是否 导入导出转换
 */
public class DictConverter implements Converter<String> {

    @Override
    public Class<?> supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    /**
     * 这里读的时候会调用
     *
     * @param context
     * @return
     */
    @Override
    public String convertToJavaData(ReadConverterContext<?> context) {
        ExcelProperty annotation = context.getContentProperty().getField().getAnnotation(ExcelProperty.class);
        String dictCode = annotation.dictCode();
        String value = context.getReadCellData().getStringValue();
        DictTypeMapper dictTypeMapper = StaticMethodGetBean.getBean(DictTypeMapper.class);
        DictDataMapper dictDataMapper = StaticMethodGetBean.getBean(DictDataMapper.class);
        LambdaQueryWrapper<DictType> dictTypeLambdaQueryWrapper = new LambdaQueryWrapper<DictType>()
                .eq(DictType::getDictType, dictCode);
        DictType dt = dictTypeMapper.selectOne(dictTypeLambdaQueryWrapper);
        if (dt == null) {
            return value;
        }
        LambdaQueryWrapper<DictData> dictDataLambdaQueryWrapper = new LambdaQueryWrapper<DictData>()
                .eq(DictData::getDictTypeId, dt.getId());
        List<DictData> dataList = dictDataMapper.selectList(dictDataLambdaQueryWrapper);
        String res = "/";
        if (!CollectionUtils.isEmpty(dataList)) {
            for (DictData data : dataList) {
                if (value.equals(data.getDictLabel())) {
                    res = data.getDictValue();
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 这里是写的时候会调用
     *
     * @return
     */
    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<String> context) {
        ExcelProperty annotation = context.getContentProperty().getField().getAnnotation(ExcelProperty.class);
        String dictCode = annotation.dictCode();
        String value = context.getValue();
        DictTypeMapper dictTypeMapper = StaticMethodGetBean.getBean(DictTypeMapper.class);
        DictDataMapper dictDataMapper = StaticMethodGetBean.getBean(DictDataMapper.class);
        LambdaQueryWrapper<DictType> dictTypeLambdaQueryWrapper = new LambdaQueryWrapper<DictType>()
                .eq(DictType::getDictType, dictCode);
        DictType dt = dictTypeMapper.selectOne(dictTypeLambdaQueryWrapper);
        if (dt == null) {
            return new WriteCellData<>(value);
        }
        LambdaQueryWrapper<DictData> dictDataLambdaQueryWrapper = new LambdaQueryWrapper<DictData>()
                .eq(DictData::getDictTypeId, dt.getId());
        List<DictData> dataList = dictDataMapper.selectList(dictDataLambdaQueryWrapper);
        String res = "/";
        if (!CollectionUtils.isEmpty(dataList)) {
            for (DictData data : dataList) {
                if (value.equals(data.getDictValue())) {
                    res = data.getDictLabel();
                    break;
                }
            }
        }
        return new WriteCellData<>(res);
    }

}
