package com.autumn.common.easyExcel;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.write.handler.AbstractRowWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义行高列宽处理器
 *
 * @author xudongmaster
 */
public class CustomRowHeightColWidthHandler extends AbstractRowWriteHandler {

    /**
     * sheet页名称列表
     */
    private List<String> sheetNameList;
    /**
     * 列宽信息
     */
    private List<RowHeightColWidthModel> colWidthList = new ArrayList<>();

    /**
     * 行高信息
     */
    private List<RowHeightColWidthModel> rowHeightList = new ArrayList<>();


    /**
     * 自定义行高列宽适配器构造方法
     *
     * @param rowHeightColWidthList 行高列宽信息
     */
    public CustomRowHeightColWidthHandler(List<RowHeightColWidthModel> rowHeightColWidthList) {
        if (CollUtil.isEmpty(rowHeightColWidthList)) {
            return;
        }
        rowHeightColWidthList = rowHeightColWidthList.stream().filter(x ->
                StrUtil.isNotBlank(x.getSheetName())).collect(Collectors.toList());
        //填充行高信息
        this.rowHeightList = rowHeightColWidthList.stream().filter(x ->
                x.getRowIndex() != null && x.getRowIndex() >= 0 && x.getRowHeight() != null && x.getRowHeight() >= 0).collect(Collectors.toList());
        //填充列宽信息
        this.colWidthList = rowHeightColWidthList.stream().filter(x ->
                x.getColIndex() != null && x.getColIndex() >= 0 && x.getColWidth() != null && x.getColWidth() >= 0).collect(Collectors.toList());
        //获取sheet页名称
        sheetNameList = this.rowHeightList.stream().map(x -> x.getSheetName()).distinct().collect(Collectors.toList());
        sheetNameList.addAll(this.colWidthList.stream().map(x -> x.getSheetName()).distinct().collect(Collectors.toList()));
        sheetNameList = sheetNameList.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public void afterRowDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row
            , Integer relativeRowIndex, Boolean isHead) {
        Sheet sheet = writeSheetHolder.getSheet();
        //不需要设置行高列宽，或者当前sheet页不需要设置行高列宽
        if ((CollUtil.isEmpty(rowHeightList) && CollUtil.isEmpty(colWidthList))
                || sheetNameList.contains(sheet.getSheetName()) == false) {
            return;
        }
        //获取当前sheet页当前行的行高信息
        List<RowHeightColWidthModel> sheetRowHeightList = rowHeightList.stream().filter(x ->
                StrUtil.equals(x.getSheetName(), sheet.getSheetName())
                        && x.getRowIndex().equals(relativeRowIndex)).collect(Collectors.toList());
        for (RowHeightColWidthModel rowHeightModel : sheetRowHeightList) {
            //行高
            Float rowHeight = rowHeightModel.getRowHeight();
            //设置行高
            if (rowHeight != null) {
                row.setHeightInPoints(rowHeight);
            }
        }
        //获取当前sheet页的列宽信息
        List<RowHeightColWidthModel> sheetColWidthList = colWidthList.stream().filter(x ->
                StrUtil.equals(x.getSheetName(), sheet.getSheetName())).collect(Collectors.toList());
        for (RowHeightColWidthModel colWidthModel : sheetColWidthList) {
            //列号
            Integer colIndex = colWidthModel.getColIndex();
            //列宽
            Integer colWidth = colWidthModel.getColWidth();
            //设置列宽
            if (colIndex != null && colWidth != null) {
                sheet.setColumnWidth(colIndex, colWidth * 256);
            }
        }
        //删除已添加的行高信息
        rowHeightList.removeAll(sheetRowHeightList);
        //删除已添加的列宽信息
        colWidthList.removeAll(sheetColWidthList);
        //重新获取要添加的sheet页姓名
        sheetNameList = this.rowHeightList.stream().map(x -> x.getSheetName()).distinct().collect(Collectors.toList());
        sheetNameList.addAll(this.colWidthList.stream().map(x -> x.getSheetName()).distinct().collect(Collectors.toList()));
        sheetNameList = sheetNameList.stream().distinct().collect(Collectors.toList());
    }
}
