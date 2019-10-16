package com.interest.model.entity;

import lombok.Data;

import java.io.UnsupportedEncodingException;

public class ParamEntity {

    private String paramKey;
    private String paramValue;

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(byte[] param) {
        try {
            this.paramValue = new String(param, "utf-8");
        } catch (UnsupportedEncodingException e) {
            this.paramValue = "";
        }
    }
}
