package com.sola.controller.shiro;


import com.sola.dao.sys.SysRoleMapper;
import com.sola.entity.sys.SysMenu;
import com.sola.entity.sys.SysRole;
import com.sola.entity.sys.SysUser;
import com.sola.service.sys.SysMenuService;
import com.sola.service.sys.SysRoleService;
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

    @Autowired
    private SysRoleService sysRoleService ;

    @Autowired
    private SysMenuService sysMenuService ;

    /* 测试使用
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
    }*/

    /**
     * 检测授权数据
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal() ;

        Map<String, Object> roleMap = getRolesByUserName(userName);
        Set<String> role = (Set<String>) roleMap.get("roleNames") ;
        Set<String> permissions = getPermissionsByRoleId((Set<String>) roleMap.get("roleIds"));

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

    /**
     * 从用户名查询角色名
     * @param userName
     * @return
     */
    private Map<String, Object> getRolesByUserName(String userName){

        Map<String, Object> result = new HashMap<String, Object>() ;
        Set<String> roleNames = new HashSet<String>() ;
        Set<String> roleIds = new HashSet<String>() ;

        SysUser sysUser = new SysUser();
        sysUser.setLoginName(userName);
        List<SysUser> list = sysUserService.findList(sysUser);

        if(list != null && !list.isEmpty()){
            SysRole sysRole = new SysRole();
            sysRole.setUserId(list.get(0).getId());
            List<SysRole> roles = sysRoleService.findList(sysRole);

            for(SysRole role : roles){
                roleNames.add(role.getEnname()) ;
                roleIds.add(role.getId()) ;
            }
        }
        result.put("roleNames", roleNames) ;
        result.put("roleIds", roleIds) ;
        return result ;
    }

    /**
     * 角色id查询权限名
     * @param roleIds
     * @return
     */
    private Set<String> getPermissionsByRoleId(Set<String> roleIds){

        Set<String> menuNames = new HashSet<String>() ;
        if(roleIds == null || roleIds.isEmpty()){
            return menuNames ;
        }
        ArrayList<String> roleIdList = new ArrayList<>(roleIds);

        SysMenu sysMenu = new SysMenu();
        sysMenu.setRoleIds(roleIdList);
        List<SysMenu> menuList = sysMenuService.findList(sysMenu);

        for (SysMenu menu : menuList){
            menuNames.add(menu.getName()) ;
        }

        return menuNames ;
    }

}
