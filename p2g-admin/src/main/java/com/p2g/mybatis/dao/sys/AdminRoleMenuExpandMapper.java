package com.p2g.mybatis.dao.sys;

import com.p2g.core.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by GJF on 2016/8/11.
 */
public interface AdminRoleMenuExpandMapper extends BaseMapper {
    List<Integer> queryMenuIdsByRoleId(@Param("roleId") Integer roleId);

    void deleteByRoleId(@Param("roleId") Integer roleId);
}
