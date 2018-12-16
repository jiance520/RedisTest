package com;

import redis.clients.jedis.Jedis;

public class TestObj {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 操作实体类对象 1
		
		Jedis redis = new Jedis("192.168.76.128",6379);
        Goods good= new Goods();  
        good.setName( "洗衣机");
        good.setNum(400);
        good.setPrice(191);
        redis.set("good".getBytes(),SerializeUtil.serialize(good));
        byte[] value = redis.get("good".getBytes());
        Object object = SerializeUtil.unserialize(value);           
         if(object!= null){
             Goods goods=(Goods) object;
             System. out.println(goods.getName());
             System. out.println(goods.getNum());
             System. out.println(goods.getPrice());
        }
        System. out.println(redis.del("good".getBytes()));       
        // 操作实体类对象2（实际上和上面是一样的）
        /*
        String key= "goods-key";
        Goods g= new Goods();
        g.setName("电风扇--d");
        g.setNum(200);
        String temp=RedisClinet.getInstance().set(g, key);
        System. out.println(temp);
        
        Object o=RedisClinet.getInstance().get(key);
        if(o!= null){
             Goods g1=(Goods)o;
             System. out.println(g1.getName());
             System. out.println(g1.getNum());
        }
        System. out.println(RedisClinet.getInstance().del(key));
        */
	}

}
