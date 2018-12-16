package com;

import redis.clients.jedis.Jedis;

public class Test {

	public static void main(String[] args) {
		
        Jedis jedis = new Jedis("192.168.76.128",6379);
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        
	}

}
