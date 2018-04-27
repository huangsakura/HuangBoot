package com.huanggit.configuration.mybatis;

import com.huanggit.general.dto.common.Money;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;

/**
 * Created by huang on 2018-04-27-0027.
 */
@MappedTypes({Money.class})
@MappedJdbcTypes({JdbcType.BIGINT, JdbcType.DECIMAL, JdbcType.NUMERIC})
public class MoneyTypeHandler extends BaseTypeHandler<Money> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Money money, JdbcType jdbcType) throws SQLException {
        if (null == money) {
            preparedStatement.setLong(i, 0L);
        } else {
            preparedStatement.setLong(i, money.getCent());
        }
    }

    @Override
    public Money getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return Money.cent(resultSet.getLong(s));
    }

    @Override
    public Money getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return Money.cent(resultSet.getLong(i));
    }

    @Override
    public Money getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return Money.cent(callableStatement.getLong(i));
    }
}
