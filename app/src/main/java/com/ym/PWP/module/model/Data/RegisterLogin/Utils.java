package com.ym.PWP.module.model.Data.RegisterLogin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Shellking on 2017/3/25.
 */

public class Utils {

    public static boolean isEmail(String email){
        String str="^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
