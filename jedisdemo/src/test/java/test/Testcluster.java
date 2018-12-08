package test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class Testcluster {
	
	@Test
	public void clustertest(){
		
		//注意：一定要保证redis集群启动成功
		//创建结点集合
		Set<HostAndPort> nodes = new HashSet<>();
		//添加结点
		nodes.add(new HostAndPort("192.168.50.10",7001));
		nodes.add(new HostAndPort("192.168.50.10",7002));
		nodes.add(new HostAndPort("192.168.50.10",7003));
		nodes.add(new HostAndPort("192.168.50.10",7004));
		nodes.add(new HostAndPort("192.168.50.10",7005));
		nodes.add(new HostAndPort("192.168.50.10",7006));
		JedisCluster cluster = new JedisCluster(nodes);
		cluster.set("k1", "v1");
		System.out.println(cluster.get("k1"));
		cluster.close();
	}
}
