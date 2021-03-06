package com.yatao.threads;

import lombok.Getter;

public enum CountryEnum {
    ONE(1, "齐"),
    TWO(2, "楚"),
    THREE(3, "燕"),
    FOUR(4, "魏"),
    FIVE(5, "赵"),
    SIX(6, "韩");

    private Integer retCode;
    private String retMessage;

    public Integer getRetCode() {
        return retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    CountryEnum(Integer reCode, String retMessage) {
        this.retCode = reCode;
        this.retMessage = retMessage;
    }

    public static CountryEnum forEach(int index) {
        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum element : myArray) {
            if (index == element.getRetCode()){
                    return element;
            }
        }
        return null;
    }
}
