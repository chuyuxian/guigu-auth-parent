package com.system.exception;

import com.system.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 全局和特定之间的异常处理问题：测试中出现了异常，全局和特定那个进行处理？
     *       如果是特定中的异常，那么则不会执行全局异常，只有执行特定异常进行处理
     *     也就是说 特定异常处理 比 全局异常处理优先级高
     */


    /**
     * 1、全局异常处理
     *    只要是出现异常报错就会执行这个异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    private Result error(Exception e) {
        System.out.println("全局....");
        e.printStackTrace();
        return Result.fail().message("执行了全局异常处理");
    }

    /**
     * 2、特定异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    private Result error(ArithmeticException e) {
        System.out.println("特定....");
        e.printStackTrace();
        return Result.fail().message("执行了特定异常处理");
    }

    /**
     * 3、自定义异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(GuiguException.class)
    @ResponseBody
    private Result error(GuiguException e) {
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMsg());
    }

}
