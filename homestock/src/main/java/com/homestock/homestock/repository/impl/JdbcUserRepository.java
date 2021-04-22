package com.homestock.homestock.repository.impl;

import com.homestock.homestock.entitites.User;
import com.homestock.homestock.mapper.UserMapper;
import com.homestock.homestock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JdbcUserRepository implements UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        var mapKeyValues = new HashMap<Integer, String>();
        mapKeyValues.put(1, "email");
        UserPreparedStatement userPreparedStatement = new UserPreparedStatement(mapKeyValues);
        var queryResult = this.jdbcTemplate.query(
                "select name, cpf,email, password from user where email = ?", userPreparedStatement, new UserMapper()
        );
        return queryResult.isEmpty() ? Optional.empty() : Optional.of(queryResult.get(0));
    }
}

class UserPreparedStatement implements PreparedStatementSetter {
    private Map<Integer, String>  mapKeyValue;
    public UserPreparedStatement(Map<Integer,String> mapKeyValue){
        this.mapKeyValue = mapKeyValue;
    }
    @Override
    public void setValues(PreparedStatement ps) throws SQLException {
        for( var entries: mapKeyValue.entrySet()){
            ps.setString(entries.getKey(), entries.getValue());
        }
    }
}