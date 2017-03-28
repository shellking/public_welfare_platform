package com.ym.PWP.module.model.bean;

import java.io.Serializable;

/**
 * @className: UserInfoModel
 * @classDescription: 数据层
 * @author: leibing
 * @createTime: 2016/8/11
 */
public class UserInfoModel implements Serializable{
    private String userid;//用户id
    private String nickname;//用户名
    private String userhead;//用户头像路径
    private String email;//用户邮箱
    private String ret;//请求状态码
    private String errcode;//错误码
    private String msg;
    private String role;//角色，是不是管理员

    private String address;
    private String password;
    private String area;
    private String sex;
    private int age;
    private int phone;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserhead() {
        return userhead;
    }

    public void setUserhead(String userhead) {
        this.userhead = userhead;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public UserInfoModel(){}
    public UserInfoModel(String nickname, int age, String address) {
        this.nickname = nickname;
        this.age = age;
        this.address = address;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
