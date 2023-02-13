package com.system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义异常类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuiguException extends RuntimeException { //RuntimeException 运行时异常

    private Integer code; //状态码
    private String msg; //信息



}
