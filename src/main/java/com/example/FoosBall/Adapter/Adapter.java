package com.example.FoosBall.Adapter;

public interface Adapter<T,U> {

    public U convertDtoToDao(T t);
    public T convertDaoToDto(U u);
}
