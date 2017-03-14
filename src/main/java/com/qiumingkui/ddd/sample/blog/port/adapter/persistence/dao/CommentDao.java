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

import com.qiumingkui.ddd.sample.blog.domain.model.BlogId;
import com.qiumingkui.ddd.sample.blog.domain.model.Comment;
import com.qiumingkui.ddd.sample.blog.domain.model.CommentId;
import com.qiumingkui.ddd.sample.blog.domain.model.Content;

@Service
public class CommentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void create(Comment comment) {
		final String SQL = "INSERT INTO comment(id,blogid,content) VALUES(?,?,?)";

		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, comment.commentId().id());
				ps.setString(2, comment.blogId().id());
				ps.setString(3, comment.content().contentTxt());
			}
		});
	}

	public void update(Comment comment) {
		final String SQL = "UPDATE comment SET blogid=?,content=? WHERE id=?";
		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, comment.blogId().id());
				ps.setString(2, comment.content().contentTxt());
				ps.setString(3, comment.commentId().id());
			}
		});
	}

	public void delete(CommentId commentId) {
		final String SQL = "DELETE FROM comment WHERE id=?";
		jdbcTemplate.update(SQL, commentId.id());
	}

	public Comment retrieve(CommentId commentId) {
		final String SQL = "SELECT * FROM comment WHERE id=?";
		List<Comment> commentList = jdbcTemplate.query(SQL, new Object[] { commentId.id() }, new CommentRowMapper());
		return commentList.size() > 0 ? commentList.get(0) : null;
	}

	class CommentRowMapper implements RowMapper<Comment> {
		@Override
		public Comment mapRow(ResultSet rs, int i) throws SQLException {
			CommentId commentId = new CommentId(rs.getString("id"));
			BlogId blogId = new BlogId(rs.getString("blogid"));
			Content content = new Content(rs.getString("content"));
			Comment comment = new Comment(commentId, blogId, content);
			return comment;
		}
	}

}
