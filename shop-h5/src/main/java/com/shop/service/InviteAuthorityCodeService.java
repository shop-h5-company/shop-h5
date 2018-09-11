package com.shop.service;

import java.util.List;

import com.shop.mybatis.model.generator.InviteAuthorityCode;

public interface InviteAuthorityCodeService {

	void insert(InviteAuthorityCode code);

	InviteAuthorityCode getByCode(String inviteAuthorityCode);

	void updateByPrimaryKeySelective(InviteAuthorityCode code2);

	void insertBatch(List<InviteAuthorityCode> codes);

	List<InviteAuthorityCode> findByTelephoneBuy(String mobile);

}
