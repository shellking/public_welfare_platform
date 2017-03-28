package com.ym.PWP.module.model.Httprequest;

import java.util.HashMap;

/**
 * Created by Shellking on 2017/3/25.
 */

public class ApiParams extends HashMap<String,String>{
    private static final long serialVersionUID = 8112047472727256876L;

    public ApiParams with(String key,String values){
        put(key,values);
        return this;
    }
}
