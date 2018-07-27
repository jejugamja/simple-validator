package com.chang.validateExecutor;

@FunctionalInterface
public interface Validator<T> {

    boolean validate(T t) throws Exception;
}
