package com.system.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.model.system.SysRole;
import com.model.vo.SysRoleQueryVo;
import com.system.mapper.SysRoleMapper;
import com.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper,SysRole>
        implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public Page<SysRole> selectPage(Page<SysRole> pagePram, SysRoleQueryVo sysRoleQueryVo) {
        Page<SysRole> pageMode = sysRoleMapper.selectPage(pagePram,sysRoleQueryVo);
        return pageMode;
    }
}
