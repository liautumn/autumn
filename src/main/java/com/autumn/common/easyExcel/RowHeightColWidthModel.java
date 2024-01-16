package com.autumn.common.easyExcel;

import lombok.Getter;

/**
 * 行高列宽信息（Builder构建者模式）
 *
 * @author xudongmaster
 */
@Getter
public class RowHeightColWidthModel {
    /**
     * sheet名称
     */
    private String sheetName;
    /**
     * 行号
     */
    private Integer rowIndex;
    /**
     * 列号
     */
    private Integer colIndex;
    /**
     * 行高
     */
    private Float rowHeight;
    /**
     * 列宽
     */
    private Integer colWidth;

    private RowHeightColWidthModel(Builder builder) {
        this.sheetName = builder.sheetName;
        this.rowIndex = builder.rowIndex;
        this.colIndex = builder.colIndex;
        this.rowHeight = builder.rowHeight;
        this.colWidth = builder.colWidth;
    }

    /**
     * 创建隐藏行信息
     *
     * @param sheetName sheet页名称
     * @param rowIndex  行号
     * @return
     */
    public static RowHeightColWidthModel createHideRowModel(String sheetName, Integer rowIndex) {
        return createRowHeightColWidthModel(sheetName, rowIndex, 0f, null, null);
    }

    /**
     * 创建隐藏列信息
     *
     * @param sheetName sheet页名称
     * @param colIndex  列号
     * @return
     */
    public static RowHeightColWidthModel createHideColModel(String sheetName, Integer colIndex) {
        return createRowHeightColWidthModel(sheetName, null, null, colIndex, 0);
    }

    /**
     * 创建行高信息
     *
     * @param sheetName sheet页名称
     * @param rowIndex  行号
     * @param rowHeight 行高
     * @return
     */
    public static RowHeightColWidthModel createRowHeightModel(String sheetName, Integer rowIndex, Float rowHeight) {
        return createRowHeightColWidthModel(sheetName, rowIndex, rowHeight, null, null);
    }

    /**
     * 创建列宽信息
     *
     * @param sheetName sheet页名称
     * @param colIndex  列号
     * @param colWidth  列宽
     * @return
     */
    public static RowHeightColWidthModel createColWidthModel(String sheetName, Integer colIndex, Integer colWidth) {
        return createRowHeightColWidthModel(sheetName, null, null, colIndex, colWidth);
    }

    /**
     * 创建行高列宽信息
     *
     * @param sheetName sheet页名称
     * @param rowIndex  行号
     * @param rowHeight 行高
     * @param colIndex  列号
     * @param colWidth  列宽
     * @return
     */
    public static RowHeightColWidthModel createRowHeightColWidthModel(String sheetName, Integer rowIndex, Float rowHeight, Integer colIndex, Integer colWidth) {
        return new Builder(sheetName)
                //行号
                .rowIndex(rowIndex)
                //行高
                .rowHeight(rowHeight)
                //显示列号
                .colIndex(colIndex)
                //列宽
                .colWidth(colWidth)
                .build();
    }

    public static class Builder {

        /**
         * sheet名称
         */
        private String sheetName;
        /**
         * 行号
         */
        private Integer rowIndex;
        /**
         * 列号
         */
        private Integer colIndex;
        /**
         * 行高
         */
        private Float rowHeight;
        /**
         * 列宽
         */
        private Integer colWidth;


        public Builder(String sheetName) {
            this.sheetName = sheetName;
        }

        public Builder rowIndex(Integer rowIndex) {
            this.rowIndex = rowIndex;
            return this;
        }

        public Builder colIndex(Integer colIndex) {
            this.colIndex = colIndex;
            return this;
        }

        public Builder rowHeight(Float rowHeight) {
            this.rowHeight = rowHeight;
            return this;
        }

        public Builder colWidth(Integer colWidth) {
            this.colWidth = colWidth;
            return this;
        }

        public RowHeightColWidthModel build() {
            return new RowHeightColWidthModel(this);
        }
    }
}
