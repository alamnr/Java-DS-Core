package org.myproject.concatenate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;

@Documented
//@Override
@Deprecated
//@SafeVarargs
//@FunctionalInterface
@SuppressWarnings({"unchecked","deprecation"})
//@Retention(RetentionPolicy.CLASS,RetentionPolicy.SOURCE,RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE)
@Inherited
//@Repeatable
@interface Author {

    String name();
    String date();
    int version() default 1;
    String lastModifiedDate() default "N/A";
    String[] reviewers();
}