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
import com.qiumingkui.sample.imedia.user.domain.model.UserName;
import com.qiumingkui.sample.imedia.user.domain.model.role.Role;

@Service
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void create(User aUser) {
		final String SQL = "INSERT INTO user(id,account,nickname,realname,password,role) VALUES(?,?,?,?,?,?)";
		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, aUser.id().key());
				ps.setString(2, aUser.account());
				ps.setString(3, aUser.name().nickname());
				ps.setString(4, aUser.name().realname());
				ps.setString(5, aUser.password());
				ps.setLong(6, aUser.role().code());
			}
		});
	}

	public void update(User aUser) {
		final String SQL = "UPDATE user SET account=?,nickname=?,realname=?,password=?,role=? WHERE id=?";
		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, aUser.account());
				ps.setString(2, aUser.name().nickname());
				ps.setString(3, aUser.name().realname());
				ps.setString(4, aUser.password());
				ps.setLong(5, aUser.role().code());
				ps.setString(6, aUser.id().key());
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

	public User getUserByAccount(String account) {
		final String SQL = "SELECT * FROM user WHERE account=?";
		List<User> userList = jdbcTemplate.query(SQL, new Object[] { account }, new UserRowMapper());
		return userList.size() > 0 ? userList.get(0) : null;
	}

	class UserRowMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int i) throws SQLException {
			UserId id = new UserId(rs.getString("id"));
			String account = rs.getString("account");
			String password = rs.getString("password");
			String nickname = rs.getString("nickname");
			String realname = rs.getString("realname");
			UserName name = new UserName(nickname, realname);
			Role role = Role.create(rs.getInt("role"));
			User user = new User(id, account, name, password, role);
			return user;
		}
	}

}
