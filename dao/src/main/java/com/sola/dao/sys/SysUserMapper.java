package com.sola.dao.sys;

import com.sola.entity.sys.SysUser;
import com.sola.utils.persistence.annotation.MyBatisDao;

import java.util.List;

@MyBatisDao
public interface SysUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbg.generated Mon Oct 29 16:44:03 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbg.generated Mon Oct 29 16:44:03 CST 2018
     */
    int insert(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbg.generated Mon Oct 29 16:44:03 CST 2018
     */
    int insertSelective(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbg.generated Mon Oct 29 16:44:03 CST 2018
     */
    SysUser selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbg.generated Mon Oct 29 16:44:03 CST 2018
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbg.generated Mon Oct 29 16:44:03 CST 2018
     */
    int updateByPrimaryKey(SysUser record);

    List<SysUser> findList(SysUser user) ;
}