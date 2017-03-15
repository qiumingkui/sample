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
import com.qiumingkui.ddd.sample.blog.domain.model.BlogStatus;
import com.qiumingkui.ddd.sample.blog.domain.model.Content;
import com.qiumingkui.ddd.sample.blog.domain.model.Title;

@Service
public class BlogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void create(Blog aBlog) {
		final String SQL = "INSERT INTO blog(id,title,content,status) VALUES(?,?,?,?)";

		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, aBlog.blogId().id());
				ps.setString(2, aBlog.title().titleTxt());
				ps.setString(3, aBlog.content().contentTxt());
				ps.setInt(4, aBlog.status().statusVal());
			}
		});
	}

	public void update(Blog aBlog) {
		final String SQL = "UPDATE blog SET title=?,content=?,status=? WHERE id=?";
		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, aBlog.title().titleTxt());
				ps.setString(2, aBlog.content().contentTxt());
				ps.setInt(3, aBlog.status().statusVal());
				ps.setString(4, aBlog.blogId().id());
			}
		});
	}

	public void delete(BlogId aBlogId) {
		final String SQL = "DELETE FROM blog WHERE id=?";
		jdbcTemplate.update(SQL, aBlogId.id());
	}

	public Blog retrieve(BlogId aBlogId) {
		final String SQL = "SELECT * FROM blog WHERE id=?";
		List<Blog> blogList = jdbcTemplate.query(SQL, new Object[] { aBlogId.id() }, new BlogRowMapper());
		return blogList.size() > 0 ? blogList.get(0) : null;
	}

	class BlogRowMapper implements RowMapper<Blog> {
		@Override
		public Blog mapRow(ResultSet rs, int i) throws SQLException {
			BlogId blogId = new BlogId(rs.getString("id"));
			Title title = new Title(rs.getString("title"));
			Content content = new Content(rs.getString("content"));
			BlogStatus status = new BlogStatus(rs.getInt("status"));
			Blog blog = new Blog(blogId, title, content, status);
			return blog;
		}
	}

}
