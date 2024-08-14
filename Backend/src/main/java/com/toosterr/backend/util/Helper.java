package com.toosterr.backend.util;

import org.springframework.stereotype.Component;

@Component
public class Helper {

    public String getCodeFromString(String str, int length) {
        return str != null && str.length() >= length ? str.substring(0, length).toUpperCase() : str.toUpperCase();
    }

}
