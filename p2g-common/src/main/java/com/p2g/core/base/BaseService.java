package com.p2g.core.base;

import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created on 2016-06-20 17:04.
 *
 * @author FanShukui
 */
public interface BaseService<T> {
    public T update(T record);

    public T insert(T record);

    @Transactional
    public void delete(Object id);

    public T queryById(Object id);

    public PageInfo<T> query(Map<String, Object> params);
}
