package com.autumn.common.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResPage implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 总数
     */
    private Long total = 0L;

    /**
     * 页码
     */
    private Integer pageNum = 1;

    /**
     * 条数
     */
    private Integer pageSize = 10;

    /**
     * 数据
     */
    private Object list;

}
