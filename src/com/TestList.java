package com;

import java.util.List;

import redis.clients.jedis.Jedis;

public class TestList {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.76.128",6379);
        System.out.println("连接成功");
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }

	}

}
