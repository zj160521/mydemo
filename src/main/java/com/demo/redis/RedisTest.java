package com.demo.redis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

public class RedisTest {
	/**
	 * https://www.cnblogs.com/chenliangcl/p/7240350.html
	 * 1.redis可存字符串、list、hash（key-value）、set、zset(有序set)
	 * 2.redis的key和value的储存大小为512M
	 * 3.持久化模式：RDB:将Reids在内存中的数据库记录定时dump到磁盘上（默认打开）
	 * 				 AOF:将redis的操作日志以追加的方式写入文件（默认关闭）
	 * 				 二者可以同时打开
	 * @param args
	 */
	public static void main(String[] args) {
		Jedis jedis = JedisUtil.getJedis();
		jedis.set("test","ut");// 字符串
//		jedis.lpush("list","ni","hao","ma");// 列表
		jedis.hset("hashtable", "f", "value1");// hash
		jedis.hset("hashtable", "s", "value2");// hash
		jedis.sadd("set_value", "a","b","c","a");//set
		//zset，score是排序权重
		jedis.zadd("zset", 5.0,"a");
		jedis.zadd("zset", 2.0,"b");
		jedis.zadd("zset", 3.0,"c");

		// 字符串获取
		System.out.println(jedis.get("test"));

		// 列表获取
		List<String> ni = jedis.lrange("list", 0, 1);
		for (String value : ni){
			System.out.printf("value = %s\n", value);
		}

		//hash值获取
		String hashValue = jedis.hget("hashtable","s");
		System.out.println(hashValue);
		Map<String, String> hashtable = jedis.hgetAll("hashtable");
		for (Map.Entry entry : hashtable.entrySet()){
			System.out.printf("key = %s, value = %s\n", entry.getKey(), entry.getValue());
		}
	}
}
