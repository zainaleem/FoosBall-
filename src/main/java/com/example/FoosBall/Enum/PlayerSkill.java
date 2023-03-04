package com.example.FoosBall.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PlayerSkill {

    EXCELLENT,GOOD,AVERAGE,BELOW_AVERAGE;

    @JsonCreator
    public static PlayerSkill getPlayerSkill(String value) {

        for (PlayerSkill playerSkill : PlayerSkill.values()) {
            return  playerSkill.valueOf(value.toUpperCase());
        }
        return null;
    }

}
