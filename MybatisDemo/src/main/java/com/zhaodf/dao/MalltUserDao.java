package com.zhaodf.dao;

import com.zhaodf.model.MalltUserCourse;
import com.zhaodf.model.MalltUserModel;
import com.zhaodf.model.MalltUserRole;

import java.util.List;
import java.util.Map;

public interface MalltUserDao {
    int insert(MalltUserModel malltUser);
    int insertMalltUser(MalltUserModel malltUser);
    List<MalltUserModel> findMalltUserById (MalltUserModel malltUser);
    List<MalltUserModel> findMalltUser (MalltUserModel malltUser);
    MalltUserModel findMalltUser2 (MalltUserModel malltUser);
    MalltUserModel findMalltUser3 (MalltUserModel malltUser);
    MalltUserModel findMalltUser4 (MalltUserModel malltUser);
    MalltUserModel selectUserRole(MalltUserModel malltUser);
    MalltUserRole selectUserRoleBySelectNesting(MalltUserModel malltUser);
    MalltUserCourse selectUserCourseBySelectNesting(MalltUserModel malltUser);
    MalltUserModel selectUserCourseByResultNesting(MalltUserModel malltUser);
    int updateMalltUserById(MalltUserModel malltUser);
    int updateMalltUser(MalltUserModel malltUser);
    int deleteByIds(List ids);
    int deleteByMap(Map map);
    int deleteByArray(Integer[] ids);
    String selectTime();
}
