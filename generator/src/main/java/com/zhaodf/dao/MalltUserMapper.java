package com.zhaodf.dao;

import com.zhaodf.model.MalltUser;
import com.zhaodf.model.MalltUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MalltUserMapper {
    long countByExample(MalltUserExample example);

    int deleteByExample(MalltUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MalltUser record);

    int insertSelective(MalltUser record);

    List<MalltUser> selectByExample(MalltUserExample example);

    MalltUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MalltUser record, @Param("example") MalltUserExample example);

    int updateByExample(@Param("record") MalltUser record, @Param("example") MalltUserExample example);

    int updateByPrimaryKeySelective(MalltUser record);

    int updateByPrimaryKey(MalltUser record);
}