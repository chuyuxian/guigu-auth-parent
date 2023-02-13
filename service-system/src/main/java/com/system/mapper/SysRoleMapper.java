package com.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.model.system.SysRole;
import com.model.vo.SysRoleQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 条件分页查询
     * @param pagePram
     * @param sysRoleQueryVo
     * @return
     */
    Page<SysRole> selectPage(Page<SysRole> pagePram,
                             @Param("vo")SysRoleQueryVo sysRoleQueryVo);
}
