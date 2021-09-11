package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App3 {
    public static void main(String[] args) {
        JedisPool pool = null;
        try {
            pool = RedisUtils.open("192.168.195.129", 6379);
            Jedis jedis = pool.getResource();
            jedis.flushAll();
            Transaction transaction = jedis.multi();
            Map<String, Double> map = new HashMap<>();
            map.put("张三", 22.0);
            map.put("李四", 20.0);
            map.put("王五", 25.0);
            transaction.zadd("age", map);
            transaction.set("name", "理化");
            transaction.lpush("age", "1","2", "3", "4");
            List<Object> list = transaction.exec();
            list.forEach(data-> System.out.println(data));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RedisUtils.close();
        }

    }
}
