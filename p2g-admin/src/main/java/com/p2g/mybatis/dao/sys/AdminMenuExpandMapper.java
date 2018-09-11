package com.p2g.mybatis.dao.sys;

import com.p2g.core.base.BaseMapper;
import com.p2g.mybatis.model.generator.AdminMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by GJF on 2016/8/11.
 */
public interface AdminMenuExpandMapper extends BaseMapper {
    List<AdminMenu> queryAdminMenus();

    int getMenu(@Param("adminId") Integer adminId, @Param("adminMenuId")Integer adminMenuId);
}
