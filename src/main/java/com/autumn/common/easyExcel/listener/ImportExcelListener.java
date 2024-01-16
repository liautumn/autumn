package com.autumn.common.easyExcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson2.JSON;
import com.autumn.common.publicEntity.PublicEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 导入监听
 *
 * @param <T>
 */
// 有个很重要的点 DataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
@Slf4j
public class ImportExcelListener<T extends PublicEntity> implements ReadListener<T> {

    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;
    /**
     * 缓存的数据
     */
    private List<T> insertDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private List<T> updateDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private IService<T> service;

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     * @param service
     */
    public ImportExcelListener(IService<T> service) {
        this.service = service;
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(T data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
        if (StringUtils.isEmpty(data.getId())) {
            insertDataList.add(data);
        } else {
            updateDataList.add(data);
        }
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (insertDataList.size() >= BATCH_COUNT) {
            InsertData();
            // 存储完成清理 list
            insertDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (updateDataList.size() >= BATCH_COUNT) {
            UpdateData();
            // 存储完成清理 list
            updateDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        InsertData();
        UpdateData();
        log.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void InsertData() {
        log.info("{}条数据，开始存储数据库！insertDataList===>", insertDataList.size());
        service.saveBatch(insertDataList);
        log.info("存储数据库成功！");
    }

    private void UpdateData() {
        log.info("{}条数据，开始存储数据库！updateDataList===>", updateDataList.size());
        service.updateBatchById(updateDataList);
        log.info("存储数据库成功！");
    }
}
