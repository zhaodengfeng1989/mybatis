package com.zhaodf.dao;

import com.zhaodf.model.MalltUser;
import org.apache.ibatis.annotations.Select;

public interface MalltUserMapper {
    @Select("select * from mallt_user where id = #{id}")
    MalltUser selectByPrimaryKey(Integer id);
}