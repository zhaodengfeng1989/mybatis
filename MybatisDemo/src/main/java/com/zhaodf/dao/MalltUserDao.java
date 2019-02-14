package com.zhaodf.dao;

import com.zhaodf.model.MalltUser;

import java.util.List;

public interface MalltUserDao {
    public int insert(MalltUser malltUser);
    public MalltUser findMalltUserById (int id);
}
