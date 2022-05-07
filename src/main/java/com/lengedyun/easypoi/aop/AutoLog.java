package com.lengedyun.easypoi.aop;



import com.lengedyun.easypoi.enums.BusinessType;
import com.lengedyun.easypoi.enums.OperateType;

import java.lang.annotation.*;

/**
 * 系统日志注解
 *
 * @Author scott
 * @email jeecgos@163.com
 * @Date 2019年1月14日
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoLog {

    /**
     * 日志内容
     *
     * @return
     */
    String value() default "";

    /**
     * 业务类型
     *
     * @return 1:台区管理;2:运营事件;3:原材料管理;4：组装监测
     */
    BusinessType businessType();

    /**
     * 操作类型
     *
     * @return （1添加，2修改，3删除 4.其他）
     */
    OperateType operateType();
}
