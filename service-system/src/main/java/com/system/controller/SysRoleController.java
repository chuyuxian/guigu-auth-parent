package com.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.model.system.SysRole;
import com.model.vo.SysRoleQueryVo;
import com.system.exception.GuiguException;
import com.system.mapper.SysRoleMapper;
import com.system.result.Result;
import com.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 角色管理模块
 * 1、查询所有角色 √
 * 2、逻辑删除 √
 * 3、条件 分页查询 √
 *      1、配置分页插件，通过配置类进行实现
 * 4、添加 √
 * 5、修改
 *      1、根据id查询 √
 *      2、最终修改 √
 * 6、批量删除 √
 */
@Api(tags = "角色管理模块接口")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;


    /**
     * 修改-最终修改信息
     * @param sysRole
     * @return
     */
    @ApiOperation("最终修改")
    @PostMapping("/update")
    private Result updateRole(@RequestBody SysRole sysRole) {
        boolean b = sysRoleService.updateById(sysRole);
        if (b) {
            return Result.ok();
        }else {
            return Result.fail();
        }
    }
    /**
     * 修改-根据id查询
     * @param sysRole
     * @return
     */
    @ApiOperation("根据id查询")
    @PostMapping("/findRoleById/{id}")
    private Result findRoleById(@PathVariable("id")Integer id,
                              @RequestBody SysRole sysRole) {
        SysRole sysRoleById = sysRoleService.getById(id);
        return Result.ok(sysRoleById);
    }

    /**
     * 添加角色
     *  1、我们在使用 @RequestBody 注解的时候请求方式不能以GET方式请求
     *  2、传递json格式数据，把json格式数据分封装到对象里面
     * @param sysRole
     * @return
     */
    @ApiOperation("添加角色")
    @PostMapping("/save")
    private Result saveRole(@RequestBody SysRole sysRole) {
        boolean save = sysRoleService.save(sysRole);
        if (save) {
            return Result.ok();
        }else {
            return Result.fail();
        }
    }


    /**
     * 条件分页查询
     * @param page 页数
     * @param limit 每页显示的数量
     * @param sysRoleQueryVo
     * @return
     */
    @ApiOperation("条件分页查询")
    @GetMapping("/{page}/{limit}")
    private Result findPageQueryRole(@PathVariable("page") Long page,
                                     @PathVariable("limit") Long limit,
                                     SysRoleQueryVo sysRoleQueryVo) {
        //创建page对象
        Page<SysRole> pagePram = new Page(page,limit);
        //调用service方法,这个不是plus里自带的，是自己手写的一个
        Page<SysRole> pageMode = sysRoleService.selectPage(pagePram,sysRoleQueryVo);
        //返回
        return Result.ok(pageMode);
    }


    /**
     * 查询全部角色信息
     * @return
     */
    @ApiOperation("查询全部角色信息的接口")
    @GetMapping("/findAll")
    private Result page() {
        //TODO 模拟异常效果  //java.lang.ArithmeticException 算数异常

        try {
            int i = 9/0;
        } catch (Exception e) {
            //手动抛出异常
            throw new GuiguException(2001,"执行了自定义异常处理");
        }

        //调用分页查询方法
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list);
    }

    /**
     * 根据ID进行逻辑删除
     * @param ids
     * @return
     */
    @ApiOperation("逻辑删除的接口")
    @DeleteMapping("/remove/{id}")
    private Result<SysRole> remove(@PathVariable("id")Long ids) {
        //调用方法删除
        if (sysRoleService.removeByIds(Arrays.asList(ids))) {
            return Result.ok();
        }else {
            return Result.fail();
        }
    }


    /**
     * 批量逻辑删除
     * json数组格式 --- java的list集合
     * @param ids 存储多个id
     * @return
     */
    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    private Result<SysRole> batchRemove(@RequestBody List<Long> ids) {
        sysRoleService.removeByIds(ids);
        return Result.ok();
    }

}
