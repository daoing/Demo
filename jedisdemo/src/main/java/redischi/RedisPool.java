package redischi;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisPool {
	public static void main(String[] args) {
		//1、创建redis池  JedisPoolConfig 应该是可以配置 连接数量等  （没有试）
		JedisPool jedisPool = new JedisPool("192.168.50.10",6379);
		//2、从redis池中获取连接  从jedis 池中获取一个对象
		Jedis jedis = jedisPool.getResource();
		//3、操作
		jedis.set("k1","v3");
		System.out.println(jedis.get("k1"));
		//4、归还连接池
		jedis.close();
		//5、关闭池
		jedisPool.close();
	}
}
