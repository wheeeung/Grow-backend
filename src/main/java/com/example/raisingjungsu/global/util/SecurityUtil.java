package com.example.raisingjungsu.global.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {
    public static String getEmail(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
