package com.zhaodf.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@MappedTypes(Date.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class ExampleTypeHandler extends BaseTypeHandler {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(parameter));
    }

    public Object getNullableResult(ResultSet resultSet, String s) throws SQLException {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultSet.getString(s));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object getNullableResult(ResultSet resultSet, int i) throws SQLException {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultSet.getString(i));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(callableStatement.getString(i));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


}
