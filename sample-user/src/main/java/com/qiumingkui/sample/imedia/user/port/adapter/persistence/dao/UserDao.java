package com.qiumingkui.sample.imedia.user.port.adapter.persistence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.qiumingkui.sample.imedia.user.domain.model.User;
import com.qiumingkui.sample.imedia.user.domain.model.UserId;
import com.qiumingkui.sample.imedia.user.domain.model.role.Role;

@Service
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void create(User aUser) {
		final String SQL = "INSERT INTO user(id,account,password,name,role) VALUES(?,?,?,?,?)";
		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, aUser.id().key());
				ps.setString(2, aUser.account());
				ps.setString(3, aUser.password());
				ps.setString(4, aUser.name());
				ps.setLong(5, aUser.role().code());
			}
		});
	}

	public void update(User aUser) {
		final String SQL = "UPDATE user SET account=?,password=?,name=?,role=? WHERE id=?";
		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, aUser.account());
				ps.setString(2, aUser.password());
				ps.setString(3, aUser.name());
				ps.setLong(4, aUser.role().code());
				ps.setString(5, aUser.id().key());
			}
		});
	}

	public void delete(UserId aUserId) {
		final String SQL = "DELETE FROM user WHERE id=?";
		jdbcTemplate.update(SQL, aUserId.key());
	}

	public User retrieve(UserId aUserId) {
		final String SQL = "SELECT * FROM user WHERE id=?";
		List<User> userList = jdbcTemplate.query(SQL, new Object[] { aUserId.key() }, new UserRowMapper());
		return userList.size() > 0 ? userList.get(0) : null;
	}

	class UserRowMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int i) throws SQLException {
			UserId id = new UserId(rs.getString("id"));
			String account = rs.getString("account");
			String password = rs.getString("password");
			String name = rs.getString("name");
			Role role = Role.create(rs.getInt("role"));
			User user = new User(id, account, password, name, role);
			return user;
		}
	}

}
