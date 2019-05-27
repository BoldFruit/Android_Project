package com.example.rebuy;

import org.litepal.crud.DataSupport;

/**
 * Created by dell on 2019/5/19.
 */

public class User extends DataSupport {
    private String hostname;
    private String password;
    private Boolean rememberPassword;
    public String getHostname(){
        return hostname;
    }
    public String getPassword(){
        return password;
    }
    public Boolean getRememberPassword(){
        return rememberPassword;
    }
    public void setHostname(String name){
        hostname = name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setRememberPassword(Boolean rememberPassword){
        this.rememberPassword = rememberPassword;
    }
}
