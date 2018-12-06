package com.sola.utils.redisUtil;

import com.sola.utils.common.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

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
     * 根据key删除value
     * @param key
     */
    public void delete(byte[] key){
        Jedis jedis = getResource();
        try{
            jedis.del(key) ;
        }finally {
            jedis.close();
        }
    }

    /**
     * 根据前缀字符串获取符合的所有key
     * @param SHIRO_SESSION_PREFIX
     * @return
     */
    public Set<byte[]> keys(String SHIRO_SESSION_PREFIX){
        Jedis jedis = getResource();
        try{
            return jedis.keys((SHIRO_SESSION_PREFIX + "*").getBytes()) ;
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

    /**
     * 序列化对象
     * @param object
     * @return
     */
    public static byte[] toBytes(Object object){
        return SerializationUtils.serialize(object) ;
    }

    /**
     * 反序列化对象
     * @param bytes
     * @return
     */
    public static Object toObject(byte[] bytes){
        return SerializationUtils.deserialize(bytes) ;
    }
}
