package com.example.clientandroidblogrest.resttool;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)

public @interface NameResourceREST {

	String value();
    
}
