package com.p2g.mybatis.dao.sys;

import com.p2g.core.base.BaseMapper;

import java.util.List;

/**
 * Created by GJF on 2016/8/11.
 */
public interface AdminUserMenuExpandMapper extends BaseMapper{
    List<Integer> queryMenuIdsByAdminId(String adminId);

    void deleteByAdminId(Integer adminId);
}
