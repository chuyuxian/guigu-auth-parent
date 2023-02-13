package com.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.model.system.SysRole;
import com.model.vo.SysRoleQueryVo;

public interface SysRoleService extends IService<SysRole> {
    /**
     * 条件分页查询
     * @param pagePram
     * @param sysRoleQueryVo
     * @return
     */
    Page<SysRole> selectPage(Page<SysRole> pagePram, SysRoleQueryVo sysRoleQueryVo);
}
