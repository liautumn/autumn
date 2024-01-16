package com.autumn.common.publicEntity;

import com.autumn.common.tree.TreePublic;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 公共字段
 *
 * @author liqiuzhuang
 * @date 2023-06-19 19:48
 */
@Data
@Accessors
public class LabelValue extends TreePublic implements Serializable {

    private static final long serialVersionUID = 1L;

    private String label;

    private String value;

}
