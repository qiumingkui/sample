package com.qiumingkui.ddd.sample.blog.port.adapter.persistence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.qiumingkui.ddd.sample.blog.domain.model.Blog;
import com.qiumingkui.ddd.sample.blog.domain.model.BlogId;
import com.qiumingkui.ddd.sample.blog.domain.model.Content;
import com.qiumingkui.ddd.sample.blog.domain.model.Title;

@Service
public class BlogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void create(Blog blog) {
		final String SQL = "INSERT INTO blog(id,title,content) VALUES(?,?,?)";

		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, blog.blogId().id());
				ps.setString(2, blog.title().titleTxt());
				ps.setString(3, blog.content().contentTxt());
			}
		});
	}

	public void update(Blog blog) {
		final String SQL = "UPDATE blog SET title=?,content=? WHERE id=?";
		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, blog.title().titleTxt());
				ps.setString(2, blog.content().contentTxt());
				ps.setString(3, blog.blogId().id());
			}
		});
	}

	public void delete(BlogId blogId) {
		final String SQL = "DELETE FROM blog WHERE id=?";
		jdbcTemplate.update(SQL, blogId.id());
	}

	public Blog retrieve(BlogId blogId) {
		final String SQL = "SELECT * FROM blog WHERE id=?";
		List<Blog> blogList = jdbcTemplate.query(SQL, new Object[] { blogId.id() }, new BlogRowMapper());
		return blogList.size() > 0 ? blogList.get(0) : null;
	}

	class BlogRowMapper implements RowMapper<Blog> {
		@Override
		public Blog mapRow(ResultSet rs, int i) throws SQLException {
			BlogId blogId = new BlogId(rs.getString("id"));
			Title title = new Title(rs.getString("title"));
			Content content = new Content(rs.getString("content"));
			Blog blog = new Blog(blogId, title, content);
			return blog;
		}
	}

}
