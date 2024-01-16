package com.autumn.common.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 条数
     */
    private Integer pageSize;

}
