package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.mybatis.dao.generator.InviteAuthorityCodeMapper;
import com.shop.mybatis.dao.sys.InviteAuthorityCodeExpandMapper;
import com.shop.mybatis.model.generator.InviteAuthorityCode;
import com.shop.mybatis.model.generator.InviteAuthorityCodeExample;
import com.shop.service.InviteAuthorityCodeService;
@Service
public class InviteAuthorityCodeServiceImple implements InviteAuthorityCodeService{
	@Autowired
	private InviteAuthorityCodeExpandMapper inviteAuthorityCodeExpandMapper;
	@Autowired
	private InviteAuthorityCodeMapper inviteAuthorityCodeMapper;
	
	@Override
	public void insert(InviteAuthorityCode code) {
		inviteAuthorityCodeExpandMapper.insert(code);
	}

	@Override
	public InviteAuthorityCode getByCode(String inviteAuthorityCode) {
		return inviteAuthorityCodeMapper.selectByPrimaryKey(inviteAuthorityCode);
	}

	@Override
	public void updateByPrimaryKeySelective(InviteAuthorityCode code2) {
		//inviteAuthorityCodeExpandMapper.updateByPrimaryKeySelective(code2);
		inviteAuthorityCodeMapper.updateByPrimaryKeySelective(code2);
	}

	@Override
	public void insertBatch(List<InviteAuthorityCode> codes) {
		inviteAuthorityCodeMapper.insertBatch(codes);
	}

	@Override
	public List<InviteAuthorityCode> findByTelephoneBuy(String mobile) {
		InviteAuthorityCodeExample e = new InviteAuthorityCodeExample();
		e.setOrderByClause("used asc");
		e.createCriteria().andTelephoneBuyEqualTo(mobile);
		List<InviteAuthorityCode> list = inviteAuthorityCodeMapper.selectByExample(e);
		return list;
	}
	
}
