package test;

import redis.clients.jedis.Jedis;

public class Test {
	
	//单实例连接  有点像jdbc
	@org.junit.Test
	public void test(){
		//1、创建jedis对象 指明连接的ip 和端口  别忘的把服务开开
		Jedis jedis = new Jedis("192.168.50.10",6379);
		//2、操作 （就是写redis命令 增删改查）
		jedis.set("k1","v2");
		System.out.println(jedis.get("k1"));
		//3、关闭连接
		jedis.close();
	}
}
