package com.p2g.mybatis.dao.sys;

import com.p2g.core.base.BaseMapper;

import java.util.List;

/**
 * Created on 2016-06-23 11:46.
 *
 * @author FanShukui
 */
public interface AdminLoginLogExpandMapper extends BaseMapper {
    void deleteBySessionId(String sessionId);

    Integer queryBySessionId(String sessionId);

    List<String> querySessionIdByAccount(String account);
}
