package com.p2g.service.impl;

import com.github.pagehelper.PageInfo;
import com.p2g.core.base.BaseServiceImpl;
import com.p2g.mybatis.dao.generator.CouponsMapper;
import com.p2g.mybatis.dao.sys.CouponsExpandMapper;
import com.p2g.mybatis.model.generator.Coupons;
import com.p2g.service.CouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by GJF on 2016/8/5.
 */
@Service
public class CouponsServiceImpl extends BaseServiceImpl<Coupons> implements CouponsService {
    @Autowired
    CouponsMapper couponsMapper;
    @Autowired
    CouponsExpandMapper couponsExpandMapper;

    @Override
    public PageInfo<Coupons> query(Map<String, Object> map) {
        if (map.get("orderBy") == null) {
            map.put("orderBy","coupons_id desc");
        }
        this.startPage(map);
        return getPage(couponsExpandMapper.query(map));
    }

    @Override
    protected Object getMapper() {
        return couponsMapper;
    }


}
