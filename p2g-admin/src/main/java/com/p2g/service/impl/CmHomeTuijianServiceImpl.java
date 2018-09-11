package com.p2g.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.p2g.core.base.BaseServiceImpl;
import com.p2g.mybatis.dao.generator.CmHomeTuijianMapper;
import com.p2g.mybatis.dao.sys.CmHomeTuijianExpandMapper;
import com.p2g.mybatis.model.generator.CmHomeTuijian;
import com.p2g.service.CmHomeTuijianService;

/**
 * 
 * @ClassName: CmAnnouncementServiceImpl 
 * @Description: 公告管理
 * @author xujianwei 
 * @date 2016年6月28日 下午3:19:10 
 *
 */
@Service
public class CmHomeTuijianServiceImpl extends BaseServiceImpl<CmHomeTuijian>
		implements CmHomeTuijianService {

	@Autowired
	private CmHomeTuijianMapper cmHomeTuijianMapper;
	@Autowired
	private CmHomeTuijianExpandMapper cmHomeTuijianExpandMapper;

	/**
	 * 
	 * <p>Title: query</p> 
	 * <p>Description: 查询首页推荐列表</p> 
	 * @param map
	 * @return 
	 * @see com.p2g.core.base.BaseService#query(java.util.Map)
	 */
	@Override
	public PageInfo<CmHomeTuijian> query(Map<String, Object> map) {
		if(map.get("orderBy")==null){
			map.put("orderBy", "update_time desc");
		}
		this.startPage(map);
		return getPage(cmHomeTuijianExpandMapper.query(map));
	}

	@Override
	protected Object getMapper() {
		return cmHomeTuijianMapper;
	}

}
