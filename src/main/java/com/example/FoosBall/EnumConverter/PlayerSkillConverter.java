package com.example.FoosBall.EnumConverter;

import com.example.FoosBall.Enum.PlayerSkill;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PlayerSkillConverter implements AttributeConverter<PlayerSkill,String> {

    @Override
    public String convertToDatabaseColumn(PlayerSkill playerSkill) {
        return playerSkill.getShortName();
    }

    @Override
    public PlayerSkill convertToEntityAttribute(String s) {
        return PlayerSkill.fromShortName(s);
    }
}
