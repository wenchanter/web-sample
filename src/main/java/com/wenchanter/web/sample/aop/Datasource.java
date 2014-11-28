package com.wenchanter.web.sample.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Datasource {
    /**
     * 主库或从库.主库:"master" 从库："slave" 
     */
    String value();
}
