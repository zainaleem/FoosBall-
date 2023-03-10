package com.example.FoosBall.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PlayerSkill {

    EXCELLENT("E"),GOOD("G"),AVERAGE("A"),BELOW_AVERAGE("BA");

    private String shortName;

    PlayerSkill(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public static PlayerSkill fromShortName(String shortName) {
        switch (shortName) {
            case "E":
                return PlayerSkill.EXCELLENT;

            case "G":
                return PlayerSkill.GOOD;

            case "A":
                return PlayerSkill.AVERAGE;

            case "BA":
                return PlayerSkill.BELOW_AVERAGE;

            default:
                throw new IllegalArgumentException("ShortName [" + shortName
                        + "] not supported.");
        }
    }

    /*@JsonCreator
    public static PlayerSkill getPlayerSkill(String value) {

        for (PlayerSkill playerSkill : PlayerSkill.values()) {
            return  playerSkill.valueOf(value.toUpperCase());
        }
        return null;
    }*/


}
