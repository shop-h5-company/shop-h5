package com.p2g.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.p2g.core.base.BaseServiceImpl;
import com.p2g.mybatis.dao.generator.CmAnnouncementMapper;
import com.p2g.mybatis.dao.sys.CmAnnouncementExpandMapper;
import com.p2g.mybatis.model.generator.CmAnnouncement;
import com.p2g.service.CmAnnouncementService;

/**
 * 
 * @ClassName: CmAnnouncementServiceImpl 
 * @Description: 公告管理
 * @author xujianwei 
 * @date 2016年6月28日 下午3:19:10 
 *
 */
@Service
public class CmAnnouncementServiceImpl extends BaseServiceImpl<CmAnnouncement>
		implements CmAnnouncementService {

	@Autowired
	private CmAnnouncementMapper cmAnnouncementMapper;
	@Autowired
	private CmAnnouncementExpandMapper cmAnnouncementExpandMapper;

	/**
	 * 
	 * <p>Title: query</p> 
	 * <p>Description: 查询公告列表</p> 
	 * @param map
	 * @return 
	 * @see com.p2g.core.base.BaseService#query(java.util.Map)
	 */
	@Override
	public PageInfo<CmAnnouncement> query(Map<String, Object> map) {
		if(map.get("orderBy")==null){
			map.put("orderBy", "update_time desc");
		}
		this.startPage(map);
		return getPage(cmAnnouncementExpandMapper.query(map));
	}

	@Override
	protected Object getMapper() {
		return cmAnnouncementMapper;
	}

}
