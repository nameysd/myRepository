package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class App2 {
    public static void main(String[] args) {
        JedisPool pool = null;
        try {
            pool = RedisUtils.open("192.168.195.129", 6379);
            Jedis jedis = pool.getResource();
            jedis.flushAll();
            jedis.hset("person", "name", "yykk");
            String s = jedis.hget("person", "name");
            System.out.println(s);

            Map<String,String> map = new HashMap<>();
            map.put("size", "10");
            map.put("length", "80");
            map.put("weight", "20");
            jedis.hmset( "product", map);
            List<String> list = jedis.hmget("product", "size", "length", "weight");
            list.forEach(str-> System.out.println(str));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RedisUtils.close();
        }



    }
}
