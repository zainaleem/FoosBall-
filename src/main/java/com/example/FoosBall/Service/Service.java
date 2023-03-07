package com.example.FoosBall.Service;

import java.util.List;

@org.springframework.stereotype.Service
public interface Service<T> {
    public List<T> findAll();

    public T add(T dto);

    public void deleteUsingId(Long id);

    public void deleteUsingName(String name);

    public T update(Long id,T dto);

    public T patch(Long id,T dto);

}
