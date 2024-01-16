package com.autumn.common.page;

import com.autumn.common.result.Result;
import com.github.pagehelper.Page;

public class ResData {

    public static Result setDataTotal(Page page, Object data) {
        ResPage resPage = new ResPage(page.getTotal(), page.getPageNum(), page.getPageSize(), data);
        return Result.successData(resPage);
    }

    public static Result setDataTotal(Page page) {
        ResPage resPage = new ResPage(page.getTotal(), page.getPageNum(), page.getPageSize(), null);
        return Result.successData(resPage);
    }

}
