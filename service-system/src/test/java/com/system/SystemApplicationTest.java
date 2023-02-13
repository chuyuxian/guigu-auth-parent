package com.system;

import com.system.mapper.SysRoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SystemApplicationTest {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Test
    public void testAdd() {

    }

}
