package com.shop.scheduler;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.serializer.UUIDCodec;
import com.shop.mybatis.model.generator.InviteAuthorityCode;
import com.shop.service.InviteAuthorityCodeService;
import com.shop.util.MdUtils;

@Component
public class InviteCodeScheduler{
	private Logger logger = Logger.getLogger(InviteCodeScheduler.class);
	@Autowired
	private InviteAuthorityCodeService inviteAuthorityCodeService;
	/**
	 * 生成权限邀请码
	 */
	public void inviteCode() throws Exception {
		Date now = new Date();
		for(int i=0;i<100;i++){
			InviteAuthorityCode code = new InviteAuthorityCode();
			String uuid = UUID.randomUUID().toString();
	    	String uuidSha1 = MdUtils.sha1(uuid+"shop").substring(0, 16);
			code.setInviteCode(uuidSha1);
			code.setInvitePersonNum(50);//可邀请50人
			code.setUsed("0");
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			code.setBatchNum("SP50"+df.format(new Date()));
			code.setTimeBuy(now);
			inviteAuthorityCodeService.insert(code);
			System.out.println("已生成,"+i);
		}
	}
    public static void main(String[] args) throws Exception{
    	String uuid = UUID.randomUUID().toString();
    	String uuidSha1 = MdUtils.sha1(uuid+"shop");
    	System.out.println(uuidSha1);    	
    	
    }
}
