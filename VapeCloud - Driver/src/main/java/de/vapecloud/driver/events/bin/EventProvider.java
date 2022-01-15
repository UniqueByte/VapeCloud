package de.vapecloud.driver.events.bin;

/*
 * Projectname: VapeCloud
 * Created AT: 15.01.2022/11:19
 * Created by Robin B. (RauchigesEtwas)
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface EventProvider {
    int priority() default 50;
}