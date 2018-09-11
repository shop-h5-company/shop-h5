package com.shop.vo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import com.shop.mybatis.model.generator.Prizeconfig;

public class PrizeRandom {
	/** 
     * 根据Math.random()产生一个double型的随机数，判断每个奖品出现的概率 
     * @param prizes 
     * @return random：奖品列表prizes中的序列（prizes中的第random个就是抽中的奖品） 
     */  
    public int getPrizeIndex(List<Prizeconfig> prizeconfigs) {  
        DecimalFormat df = new DecimalFormat("######0.00");    
        int random = -1;  
        try{  
            //计算总权重  
            double sumWeight = 0;  
            for(Prizeconfig p : prizeconfigs){  
                //sumWeight += p.getPrize_weight();  
                sumWeight += p.getProbability();
            }  
  
            //产生随机数  
            double randomNumber;  
            randomNumber = Math.random();  
            System.out.println("randomNumber:"+randomNumber);
            //根据随机数在所有奖品分布的区域并确定所抽奖品  
            //(注：算法原理，先生成一个 [0,1) 之间的随机小数，和集合中相邻两个数的权重比（两个数分别的从小到大的权重和:比如3、4进行比较，则是123和1234的权重和进行比较）进行比较，
            //如果在这两个数的范围内，则返回较大数的索引（较大的数即为抽中的数）。 
            //总结：这种计算方法，1、必定中奖，不会出现不会中奖的情况。2、哪种奖项的权重越大，则中奖几率越大（d1、d2两个权重数是一个范围，如果突然一个数权重很大，则扩大了d1、d2的范围）。
            double d1 = 0;  
            double d2 = 0;            
            for(int i=0;i<prizeconfigs.size();i++){//遍历每一个奖品，如果该商品符合相应的条件，就返回（抽中）该商品的索引。  
                if(i==0){  
                    d1 = 0;  
                }else{  
                    d1 +=Double.parseDouble(String.valueOf(prizeconfigs.get(i-1).getProbability()))/sumWeight;  
                }  
                d2 += Double.parseDouble(String.valueOf(prizeconfigs.get(i).getProbability()))/sumWeight;  
                if(randomNumber >= d1 && randomNumber <= d2){
                    random = i;  
                    break;  
                }  
            }  
        }catch(Exception e){  
            System.out.println("生成抽奖随机数出错，出错原因：" +e.getMessage());  
        }  
        return random;  
    }
    public static void main(String[] args){
    	PrizeRandom pr = new PrizeRandom();
    	List<Prizeconfig> prizeconfigs = new ArrayList<Prizeconfig>();
    	Prizeconfig p1 = new Prizeconfig();
    	p1.setProbability(1);
    	prizeconfigs.add(p1);
    	Prizeconfig p2 = new Prizeconfig();
    	p2.setProbability(5);
    	prizeconfigs.add(p2);
    	Prizeconfig p3 = new Prizeconfig();
    	p3.setProbability(10);
    	prizeconfigs.add(p3);
    	Prizeconfig p4 = new Prizeconfig();
    	p4.setProbability(100);
    	prizeconfigs.add(p4);
    	Prizeconfig p5 = new Prizeconfig();
    	p5.setProbability(1);
    	prizeconfigs.add(p5);
    	
    	int prizeIndex = pr.getPrizeIndex(prizeconfigs);
    	System.out.println(prizeIndex);
    }
}
