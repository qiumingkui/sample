package com.qiumingkui.sample.iwords.blog.port.adapter.persistence.dao;

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

import com.qiumingkui.sample.iwords.blog.domain.model.Blog;
import com.qiumingkui.sample.iwords.blog.domain.model.BlogId;
import com.qiumingkui.sample.iwords.blog.domain.model.BlogStatus;
import com.qiumingkui.sample.iwords.blog.domain.model.Content;
import com.qiumingkui.sample.iwords.blog.domain.model.Title;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Author;

@Service
public class BlogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void create(Blog aBlog) {
		final String SQL = "INSERT INTO blog(id,title,content,status,commentnumber,createtime,modifytime) VALUES(?,?,?,?,?,?,?)";

		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, aBlog.blogId().id());
				ps.setString(2, aBlog.title().titleTxt());
				ps.setString(3, aBlog.content().contentTxt());
				ps.setInt(4, aBlog.status().statusVal());
				ps.setInt(5, aBlog.commentNumber());
				ps.setTimestamp(6, aBlog.createTime());
				ps.setTimestamp(7, aBlog.modifyTime());
			}
		});
	}

	public void update(Blog aBlog) {
		final String SQL = "UPDATE blog SET title=?,content=?,status=?,commentnumber=?,modifytime=? WHERE id=?";
		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, aBlog.title().titleTxt());
				ps.setString(2, aBlog.content().contentTxt());
				ps.setInt(3, aBlog.status().statusVal());
				ps.setInt(4, aBlog.commentNumber());
				ps.setTimestamp(5, aBlog.modifyTime());
				ps.setString(6, aBlog.blogId().id());
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
			int commentNumber = rs.getInt("commentnumber");
			Timestamp createTime = rs.getTimestamp("createtime");
			Timestamp modifyTime = rs.getTimestamp("modifytime");
			Author author = new Author("","","",false);
			Blog blog = new Blog(blogId, title, content, author, status, commentNumber,createTime, modifyTime);
			return blog;
		}
	}

}
