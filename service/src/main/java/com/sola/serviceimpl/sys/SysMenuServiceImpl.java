package com.sola.serviceimpl.sys;

import com.sola.dao.sys.SysMenuMapper;
import com.sola.entity.sys.SysMenu;
import com.sola.service.sys.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper ;

    @Override
    public int deleteByPrimaryKey(String id) {
        return sysMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysMenu record) {
        return sysMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(SysMenu record) {
        return sysMenuMapper.insertSelective(record);
    }

    @Override
    public SysMenu selectByPrimaryKey(String id) {
        return sysMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysMenu record) {
        return sysMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysMenu record) {
        return sysMenuMapper.updateByPrimaryKey(record);
    }
}
