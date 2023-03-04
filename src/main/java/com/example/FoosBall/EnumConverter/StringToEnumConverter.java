package com.example.FoosBall.EnumConverter;

import com.example.FoosBall.Enum.PlayerSkill;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.core.convert.converter.Converter;


public class StringToEnumConverter implements Converter<String,PlayerSkill> {

    @Override
    public PlayerSkill convert(String source) {
        return PlayerSkill.valueOf(source.toUpperCase());
    }

}
