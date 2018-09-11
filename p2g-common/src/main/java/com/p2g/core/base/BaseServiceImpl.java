package com.p2g.core.base;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.p2g.core.util.DataUtil;
import com.p2g.core.util.InstanceUtil;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created on 2016-06-23 14:43.
 *
 * @author FanShukui
 */
public abstract class BaseServiceImpl<T extends Serializable> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 启动分页查询
     */
    protected void startPage(Map<String, Object> params) {
        if (DataUtil.isEmpty(params.get("pageNum"))) {
            params.put("pageNum", 1);
        }
        if (DataUtil.isEmpty(params.get("pageSize"))) {
            params.put("pageSize", 10);
        }
        if (DataUtil.isEmpty(params.get("orderBy"))) {
            params.put("orderBy", "create_time desc");
        }
        PageHelper.startPage(params);
    }

    @SuppressWarnings("unchecked")
    private BaseServiceImpl<T> getService() {
        return ContextLoader.getCurrentWebApplicationContext().getBean(getClass());
    }

    /**
     * 根据Id查询(默认类型T)
     */
    public PageInfo<T> getPage(Page<Object> ids) {
        Page<T> page = new Page<T>(ids.getPageNum(), ids.getPageSize());
        page.setTotal(ids.getTotal());
        if (ids != null) {
            page.clear();
            BaseServiceImpl<T> service = getService();
            for (Object id : ids) {
                page.add(service.queryById(id));
            }
        }
        return new PageInfo<T>(page);
    }

    /**
     * 根据Id查询(cls返回类型Class)
     */
    public <K> PageInfo<K> getPage(Page<Object> ids, Class<K> cls) {
        Page<K> page = new Page<K>(ids.getPageNum(), ids.getPageSize());
        page.setTotal(ids.getTotal());
        if (ids != null) {
            page.clear();
            BaseServiceImpl<T> service = getService();
            for (Object id : ids) {
                T t = service.queryById(id);
                K k = null;
                try {
                    k = cls.newInstance();
                } catch (Exception e1) {
                }
                if (k != null) {
                    try {
                        PropertyUtils.copyProperties(k, t);
                    } catch (Exception e) {
                    }
                    page.add(k);
                }
            }
        }
        return new PageInfo<K>(page);
    }

    /**
     * 根据Id查询(默认类型T)
     */
    public List<T> getList(List<Object> ids) {
        List<T> list = InstanceUtil.newArrayList();
        if (ids != null) {
            for (Object id : ids) {
                list.add(getService().queryById(id));
            }
        }
        return list;
    }

    /**
     * 根据Id查询(cls返回类型Class)
     */
    public <K> List<K> getList(List<Object> ids, Class<K> cls) {
        List<K> list = InstanceUtil.newArrayList();
        if (ids != null) {
            for (Object id : ids) {
                T t = getService().queryById(id);
                K k = null;
                try {
                    k = cls.newInstance();
                } catch (Exception e1) {
                }
                if (k != null) {
                    try {
                        PropertyUtils.copyProperties(k, t);
                    } catch (Exception e) {
                    }
                    list.add(k);
                }
            }
        }
        return list;
    }

    @Transactional
    public void delete(Object id) {
        try {
            if (id instanceof Integer)
                getMapper().getClass().getMethod("deleteByPrimaryKey", Integer.class).invoke(getMapper(), id);
            else if (id instanceof Long)
                getMapper().getClass().getMethod("deleteByPrimaryKey", Long.class).invoke(getMapper(), id);
            else if (id instanceof String)
                getMapper().getClass().getMethod("deleteByPrimaryKey", String.class).invoke(getMapper(), id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Transactional
    public T update(T record) {
        try {
            getMapper().getClass().getMethod("updateByPrimaryKey", record.getClass()).invoke(getMapper(), record);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return record;
    }

    public T insert(T record) {
        try {
            getMapper().getClass().getMethod("insert", record.getClass()).invoke(getMapper(), record);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return record;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public T queryById(Object id) {
        try {
            T t = null;
            if (id instanceof Integer)
                t = (T) getMapper().getClass().getMethod("selectByPrimaryKey", Integer.class).invoke(getMapper(), id);
            else if (id instanceof Long)
                t = (T) getMapper().getClass().getMethod("selectByPrimaryKey", Long.class).invoke(getMapper(), id);
            else if (id instanceof String)
                t = (T) getMapper().getClass().getMethod("selectByPrimaryKey", String.class).invoke(getMapper(), id);
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    protected abstract Object getMapper();
}
