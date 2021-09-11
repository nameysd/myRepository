package com.bjpowernode;

import redis.clients.jedis.Jedis;


public class App {

    public static void main(String[] args) throws InterruptedException {

        Jedis jedis = new Jedis("192.168.195.129", 6379);
        jedis.set("name", "张三");
        String name = jedis.get("name");
        System.out.println(name);
        jedis.append("name", "666");
        String newName = jedis.get("name");
        System.out.println(newName);

    }
}
