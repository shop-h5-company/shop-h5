package com.p2g.core.base;

import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created on 2016-06-23 14:49.
 *
 * @author FanShukui
 */
public interface BaseCacheService<T> {

    public T update(T record,String idName);

    public T insert(T record,String idName);

    @Transactional
    public void delete(Object id);

    public T queryById(Object id);

    public PageInfo<T> query(Map<String, Object> params);

    public T queryByCode(Object code,String idName);
}
