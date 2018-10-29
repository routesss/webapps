package com.sola.serviceimpl.sys;

import com.sola.dao.sys.SysUserRoleMapper;
import com.sola.entity.sys.SysUserRole;
import com.sola.service.sys.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper ;

    @Override
    public int insert(SysUserRole record) {
        return sysUserRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUserRole record) {
        return sysUserRoleMapper.insertSelective(record);
    }
}
