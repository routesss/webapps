package com.sola.utils.MyShiroSessionDao;

import com.sola.utils.redisUtil.RedisUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by sola on 2018/10/29.
 */
public class ShiroSessionRedisDao extends AbstractSessionDAO {

    @Autowired
    private RedisUtil redisUtil ;

    //session前缀
    private final String SHIRO_SESSION_PREFIX = "shiro-session-" ;

    //将key转换为byte[]类型数据
    private byte[] getKey(String key){
        return (SHIRO_SESSION_PREFIX + key).getBytes() ;
    }

    /**
     * 创建session
     * @param session
     * @return 返回值需要查资料
     */
    @Override
    protected Serializable doCreate(Session session) {

        Serializable sessionId = generateSessionId(session);

        byte[] key = getKey(session.getId().toString()) ;
        byte[] value = SerializationUtils.serialize(session) ;

        redisUtil.set(key, value) ;
        redisUtil.expire(key, 1800);

        return sessionId;
    }

    /**
     * 获取session
     * @param serializable
     * @return
     */
    @Override
    protected Session doReadSession(Serializable serializable) {
        if(serializable == null){
            return null ;
        }
        byte[] key = getKey(serializable.toString()) ;
        byte[] value = redisUtil.get(key) ;

        return (Session)SerializationUtils.deserialize(value);
    }

    /**
     * 更新
     * @param session
     * @throws UnknownSessionException
     */
    @Override
    public void update(Session session) throws UnknownSessionException {

    }

    @Override
    public void delete(Session session) {

    }

    @Override
    public Collection<Session> getActiveSessions() {
        return null;
    }
}
