package com.shop.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 清理存储手机验证码的map  项目启动时运行
 * @author lz
 * Date now = new Date();
   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   Constants.verifyMobile.put(mobile, strB.toString()+df.format(now));//时间是为了清理map中的数据
 */
public class CleanVerifyMap {
	static{
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				Map<String,String> map = Constants.verifyMobile;
				Set<String> mobiles = map.keySet();
				List<String> temp = new ArrayList<String>();
				for(String mobile : mobiles){
					String time = map.get(mobile).substring(4);
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					try {
						long old = df.parse(time).getTime();
						long now = new Date().getTime();
						if(old < now-10*60*1000L){ //删除(当前时间的)10分钟之前的消息
							//map.remove(mobile); 并发修改错误
							temp.add(mobile);
						}
						
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				//删除
				for(String mobile:temp){
					map.remove(mobile);
				}
			}
		}, new Date(), 1*60*60*1000L);//启动即执行，以后每1小时执行一次
	}
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("123", "12342014-02-01 02:01:01");
		map.put("124", "12342014-02-01 02:01:01");
		map.put("125", "12342014-02-01 02:01:01");
		map.put("126", "12342014-02-01 02:01:01");
		Set<String> mobiles = map.keySet();
		List<String> temp = new ArrayList<String>();
		for(String mobile : mobiles){
			String time = map.get(mobile).substring(4);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				long old = df.parse(time).getTime();
				long now = new Date().getTime();
				if(old < now-5*60*1000L){ //删除5分钟之前的消息
					//map.remove(mobile); 并发修改错误
					temp.add(mobile);
				}
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		//删除
		for(String mobile:temp){
			map.remove(mobile);
		}
	}
}
