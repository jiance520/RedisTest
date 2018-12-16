package com;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class TestKey {

	public static void main(String[] args) {
		
		Jedis jedis = new Jedis("192.168.76.128",6379);
        System.out.println("连接成功");
 
        // 获取数据并输出
        Set<String> keys = jedis.keys("*"); 
        Iterator<String> it=keys.iterator() ;   
        while(it.hasNext()){   
            String key = it.next();   
            System.out.println(key);   
        }
	}

}
