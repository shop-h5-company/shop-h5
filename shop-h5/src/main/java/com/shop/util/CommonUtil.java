package com.shop.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.UUID;

public class CommonUtil {
	
	static DecimalFormat df = new DecimalFormat("#.00");
	
	public static String randomUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static double formatDecimal(double num){
		return Double.parseDouble(df.format(num));
	}
	
	public static double formatDecimalFloor(double num){
		df.setRoundingMode(RoundingMode.FLOOR);
		return Double.parseDouble(df.format(num));
	}
	
	public static String randomLogNo(){
		return UUID.randomUUID().toString().replaceAll("-", "").substring(10, 25) + 
				((int)(Math.random()*8999+1000));
	}

	public static double calProfit(double amt,double rates,int days){
		double profit = CommonUtil.formatDecimalFloor((rates/36500d)*amt*days);
		return profit;
	}
	
	public static void main(String[] args) {
		System.out.println((Math.pow(1+6d/100, 1d/365d)-1)*10000d);
		System.out.println(formatDecimalFloor(2.3363));
		System.out.println(formatDecimalFloor(2.0));
    }
}
