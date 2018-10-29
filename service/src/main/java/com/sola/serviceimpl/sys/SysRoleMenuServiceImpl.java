package com.sola.serviceimpl.sys;

import com.sola.dao.sys.SysRoleMenuMapper;
import com.sola.entity.sys.SysRoleMenu;
import com.sola.service.sys.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper ;

    @Override
    public int insert(SysRoleMenu record) {
        return sysRoleMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRoleMenu record) {
        return sysRoleMenuMapper.insertSelective(record);
    }
}
