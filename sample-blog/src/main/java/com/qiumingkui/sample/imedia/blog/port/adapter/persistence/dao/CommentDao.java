package com.qiumingkui.sample.imedia.blog.port.adapter.persistence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.qiumingkui.sample.imedia.blog.domain.model.Content;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntryId;
import com.qiumingkui.sample.imedia.blog.domain.model.comment.Comment;
import com.qiumingkui.sample.imedia.blog.domain.model.comment.CommentId;

@Service
public class CommentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void create(Comment aComment) {
		final String SQL = "INSERT INTO comment(id,blogid,content,createtime) VALUES(?,?,?,?)";

		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, aComment.id().key());
				ps.setString(2, aComment.blogEntryId().key());
				ps.setString(3, aComment.content().contentTxt());
				ps.setTimestamp(4, aComment.createTime());
			}
		});
	}

	public void update(Comment aComment) {
		final String SQL = "UPDATE comment SET blogid=?,content=?,createtime=? WHERE id=?";
		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, aComment.blogEntryId().key());
				ps.setString(2, aComment.content().contentTxt());
				ps.setTimestamp(3, aComment.createTime());
				ps.setString(4, aComment.id().key());		
			}
		});
	}

	public void delete(CommentId aCommentId) {
		final String SQL = "DELETE FROM comment WHERE id=?";
		jdbcTemplate.update(SQL, aCommentId.key());
	}

	public Comment retrieve(CommentId aCommentId) {
		final String SQL = "SELECT * FROM comment WHERE id=?";
		List<Comment> commentList = jdbcTemplate.query(SQL, new Object[] { aCommentId.key() }, new CommentRowMapper());
		return commentList.size() > 0 ? commentList.get(0) : null;
	}

	class CommentRowMapper implements RowMapper<Comment> {
		@Override
		public Comment mapRow(ResultSet rs, int i) throws SQLException {
			CommentId commentId = new CommentId(rs.getString("id"));
			BlogEntryId blogEntryId = new BlogEntryId(rs.getString("blogid"));
			Content content = new Content(rs.getString("content"));
			Timestamp createTime = new Timestamp(rs.getLong("createtime"));
			Comment comment = new Comment();
			comment.init(commentId, blogEntryId, content,createTime);
			return comment;
		}
	}

}
