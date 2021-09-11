package com.bjpowernode;


import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {
    static JedisPool jedisPool = null;
    public static JedisPool open(String host, int port){
        if(jedisPool == null){
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(20);
            config.setMaxIdle(5);
            jedisPool = new JedisPool(config,host,port);
        }
        return jedisPool;
    }

    public static void close(){
        if(jedisPool!=null){
            jedisPool.close();
        }
    }
}
