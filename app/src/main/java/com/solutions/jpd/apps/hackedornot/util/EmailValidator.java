package com.solutions.jpd.apps.hackedornot.util;

import android.util.Patterns;

/**
 * Created by Josermando Peralta on 11/10/2016.
 */
public class EmailValidator {
    private static final String LOG_TAG = EmailValidator.class.getSimpleName();

    public final static boolean isEmailValid(String target){
        if(target.isEmpty()){
            return false;
        }
        else{
            return Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}
