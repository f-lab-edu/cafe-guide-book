package com.flab.cafeguidebook.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.beans.factory.annotation.Qualifier;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier(value = "masterDataSource")
public @interface MasterDataSource {

}
