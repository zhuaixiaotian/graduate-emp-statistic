package com.roadjava.statistic.bean.res;

import com.roadjava.statistic.util.Constants;
import lombok.Data;

import java.util.List;

/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Data
public class TableResult<T> {
    /**
     * 查询出的记录
     */
    private List<T> rows;
    /**
     * 总条数
     */
    private long totalCount;

    /**
     * 总的页数
     * totalCount:91
     * pageSize:10
     * ==== 10页
     * @return
     */
    public long getPageCount() {
        long pageCount;
        if (totalCount % Constants.PAGE_SIZE == 0) {
            pageCount = totalCount / Constants.PAGE_SIZE;
        } else {
            pageCount = totalCount / Constants.PAGE_SIZE + 1;
        }
        return pageCount;
    }
}
