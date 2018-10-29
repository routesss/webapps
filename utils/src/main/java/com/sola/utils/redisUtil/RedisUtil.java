package com.sola.utils.redisUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/** redis工具类
 * Created by sola on 2018/10/29.
 */
@Component
public class RedisUtil {

    private static final Logger logger = LoggerFactory.getLogger(RedisUtil.class) ;

    @Autowired
    private JedisPool jedisPool ;

    /**
     * 获取连接
     * @return
     */
    private Jedis getResource(){
        return jedisPool.getResource() ;
    }

    /**
     * 添加数据
     * @param key
     * @param value
     * @return
     */
    public byte[] set(byte[] key, byte[] value){

        Jedis jedis = getResource();
        try{
            jedis.set(key, value) ;
        }finally {
            jedis.close();
        }
        return value ;
    }

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    public byte[] get(byte[] key){
        Jedis jedis = getResource();
        try{
            return jedis.get(key) ;
        }finally {
            jedis.close();
        }
    }

    /**
     * 指定key设置超时时间
     * @param key
     * @param i
     */
    public void expire(byte [] key, int i){

        Jedis jedis = getResource();

        try{
            jedis.expire(key, i) ;
        }finally {
            jedis.close();
        }
    }
}
