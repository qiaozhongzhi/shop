package org.wendu.dye.common.page;

import java.util.List;

/**
 * 负责执行查询的对象
 * @param <T>
 */
public interface QueryAction<T> {
    List<T> executeQuery();
}
