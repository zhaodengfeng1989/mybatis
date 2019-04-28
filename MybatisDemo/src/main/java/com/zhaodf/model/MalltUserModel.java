package com.zhaodf.model;

import javax.management.relation.Role;
import java.util.Date;

public class MalltUserModel {
    private Integer id;
    private String name;
    private String email;
    private String mobile;
    private Date birthday;

    private MalltUserRole role;

    public MalltUserModel() {
    }

    public MalltUserModel(Integer id, String name, String email, String mobile, Date birthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public MalltUserRole getRole() {
        return role;
    }

    public void setRole(MalltUserRole role) {
        this.role = role;
    }

    public void init(){
        System.out.println("调用init方法：name:"+this.name+",mobile="+this.mobile);
    }
}
