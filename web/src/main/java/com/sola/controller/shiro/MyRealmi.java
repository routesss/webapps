package com.sola.controller.shiro;


import com.sola.entity.sys.SysUser;
import com.sola.service.sys.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * 自定义 Realm 域
 */
public class MyRealmi extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(MyRealmi.class);

    @Autowired
    private SysUserService sysUserService ;

    private static Map<String, String> userData = new HashMap<String, String>() ;//模拟用户数据  后续从数据库中读取信息
    private static Map<String, Set> roleData = new HashMap<String, Set>() ;//模拟角色数据
    private static Map<String, Set> permissionsData = new HashMap<String, Set>() ;//模拟权限数据
    static {
        Md5Hash md5Hash = new Md5Hash("123456");
        userData.put("sola", md5Hash.toString()) ;
        userData.put("admin", md5Hash.toString()) ;

        HashSet<String> roleSet = new HashSet<>();
        roleSet.add("admin") ;
        roleSet.add("root") ;
        roleData.put("sola", roleSet) ;

        HashSet<String> permissionSet = new HashSet<String>() ;
        permissionSet.add("user:add") ;
        permissionSet.add("user:delete") ;
        permissionsData.put("sola", permissionSet) ;
    }

    /**
     * 检测授权数据
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal() ;

        //测试数据是写死的 需要从数据库中获取
        Set<String> role = getRolesByUserName(userName);
        Set<String> permissions = getPermissionsByUserName(userName);

        SimpleAuthorizationInfo simpleAuthenticationInfo = new SimpleAuthorizationInfo();
        simpleAuthenticationInfo.setStringPermissions(permissions);//设置权限数据
        simpleAuthenticationInfo.setRoles(role);//设置角色数据

        return simpleAuthenticationInfo;
    }


    /**
     * 检测用户登录相关
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String username = (String) authenticationToken.getPrincipal();//得到用户名
        String password = new String((char[]) authenticationToken.getCredentials());//得到密码

        String checkPassword = checkUser(username) ;

        if(checkPassword != null){
            //验证成功 如果身份认证验证成功，返回一个AuthenticationInfo实现，shiro会检查 这里checkPassword和token里的密码是否一致 交给shiro去处理
            SimpleAuthenticationInfo authentication = new SimpleAuthenticationInfo(username, checkPassword, getName());
            //authentication.setCredentialsSalt(ByteSource.Util.bytes("salt")); //shiro 加盐时使用
            return authentication;
        }else{
            //如果用户名错误
            throw new UnknownAccountException("用户不存在");
        }
    }


    /**
     * Realm域名字
     *
     * @return
     */
    @Override
    public String getName() {
        return this.getClass().getName();
    }

    /**
     * 根据用户名查询用户是否存在 存在返回密码 不存在返回null
     * @param userName
     * @return
     */
    private String checkUser(String userName){
        SysUser sysUser = new SysUser();
        sysUser.setLoginName(userName);
        List<SysUser> list = sysUserService.findList(sysUser);
        if(list != null && !list.isEmpty()){
            return list.get(0).getPassword() ;
        }else{
            return null ;
        }
        //return userData.get(userName) ;
    }

    private Set<String> getRolesByUserName(String userName){

        return roleData.get(userName) ;
    }

    private Set<String> getPermissionsByUserName(String userName){

        return permissionsData.get(userName) ;
    }

}
