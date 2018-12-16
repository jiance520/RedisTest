package com;

import redis.clients.jedis.Jedis;

public class TestExpire {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
        Jedis jedis = new Jedis("192.168.76.128",6379);
		
        System.out.println("连接成功");
        
        //删除数据
        if(jedis.get("runoobkey") != null){
         jedis.del("runoobkey");
		 System.out.println("del runoobkey");
        }
        //设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
        System.out.println("=======================");
        //expire:设置生效时间 (秒)
        jedis.expire("runoobkey", 5);
		Thread.sleep(3000);
		/*
		 * ttl:剩余生存时间
		      当 key 不存在时，返回 -2 。
		      当 key 存在但没有设置剩余生存时间时，返回 -1 。
		      否则，以秒为单位，返回 key 的剩余生存时间。
		 */
		System.out.println("时间："+jedis.ttl("runoobkey"));
		System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
		System.out.println("=======================");
		Thread.sleep(3000);
		System.out.println("时间："+jedis.ttl("runoobkey"));
		System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
	}

}
