package com.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.mybatis.dao.generator.InviteAuthorityCodeMapper;
import com.shop.mybatis.dao.sys.InviteAuthorityCodeExpandMapper;
import com.shop.mybatis.model.generator.InviteAuthorityCode;
import com.shop.service.InviteAuthorityCodeService;
@Service
public class InviteAuthorityCodeServiceImple implements InviteAuthorityCodeService{
	@Autowired
	private InviteAuthorityCodeMapper inviteAuthorityCodeMapper;
	
	@Override
	public void insert(InviteAuthorityCode code) {
		inviteAuthorityCodeMapper.insert(code);
	}
	
}
