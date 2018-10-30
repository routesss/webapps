package com.sola.utils.MyShiroSessionDao;

import com.sola.utils.redisUtil.RedisUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sola on 2018/10/29.
 */
public class ShiroSessionRedisDao extends AbstractSessionDAO {

    @Autowired
    private RedisUtil redisUtil ;

    /**
     * session前缀
     */
    private final String SHIRO_SESSION_PREFIX = "shiro-session-" ;


    /**
     * 创建session
     * @param session
     * @return 返回值需要查资料
     */
    @Override
    protected Serializable doCreate(Session session) {

        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId); //绑定session和sessionid
        saveSession(session);

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
        saveSession(session);
    }

    /**
     * 删除session
     * @param session
     */
    @Override
    public void delete(Session session) {
        if(session != null && session.getId() != null){
            byte[] key = getKey(session.getId().toString());
            redisUtil.delete(key);
        }
    }

    /**
     * 获取全部session
     * @return
     */
    @Override
    public Collection<Session> getActiveSessions() {
        Set<byte[]> keys = redisUtil.keys(SHIRO_SESSION_PREFIX);

        Set<Session> sessions = new HashSet<Session>() ;
        if(CollectionUtils.isEmpty(keys)){
            return sessions ;
        }
        for(byte[] key : keys){
            Session session = (Session)SerializationUtils.deserialize(redisUtil.get(key)) ;
            sessions.add(session) ;
        }
        return sessions;
    }

    /**
     * 将key转换为byte[]类型数据
     * @param key
     * @return
     */
    private byte[] getKey(String key){
        return (SHIRO_SESSION_PREFIX + key).getBytes() ;
    }

    /**
     * 保存session
     * @param session
     */
    private void saveSession(Session session){
        if(session != null && session.getId() != null){
            byte[] key = getKey(session.getId().toString()) ;
            byte[] value = SerializationUtils.serialize(session) ;

            redisUtil.set(key, value) ;
            redisUtil.expire(key, 1800);
        }
    }
}
