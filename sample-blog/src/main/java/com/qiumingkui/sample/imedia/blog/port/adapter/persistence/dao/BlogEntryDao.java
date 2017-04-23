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
import com.qiumingkui.sample.imedia.blog.domain.model.Title;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntry;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntryComment;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntryId;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status.BlogEntryStatus;
import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogAuthor;
import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogMemberBuilder;

@Service
public class BlogEntryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void create(BlogEntry aBlogEntry) {
		final String SQL = "INSERT INTO blogentry(id,title,content,status,commentnumber,authorid,authoraccount,authorname,createtime,modifytime) VALUES(?,?,?,?,?,?,?,?,?,?)";

		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, aBlogEntry.id().key());
				ps.setString(2, aBlogEntry.title().titleTxt());
				ps.setString(3, aBlogEntry.content().contentTxt());
				ps.setInt(4, aBlogEntry.status().code());
				ps.setInt(5, aBlogEntry.blogEntryComment().commentNumber());
				ps.setString(6, aBlogEntry.blogAuthor().id());
				ps.setString(7, aBlogEntry.blogAuthor().account());
				ps.setString(8, aBlogEntry.blogAuthor().name());
				ps.setTimestamp(9, aBlogEntry.createTime());
				ps.setTimestamp(10, aBlogEntry.modifyTime());
			}
		});
	}

	public void update(BlogEntry aBlogEntry) {
		final String SQL = "UPDATE blogentry SET title=?,content=?,status=?,commentnumber=?,authorid=?,authoraccount=?,authorname=?,modifytime=? WHERE id=?";
		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, aBlogEntry.title().titleTxt());
				ps.setString(2, aBlogEntry.content().contentTxt());
				ps.setInt(3, aBlogEntry.status().code());
				ps.setInt(4, aBlogEntry.blogEntryComment().commentNumber());
				ps.setString(5, aBlogEntry.blogAuthor().id());
				ps.setString(6, aBlogEntry.blogAuthor().account());
				ps.setString(7, aBlogEntry.blogAuthor().name());
				ps.setTimestamp(8, aBlogEntry.modifyTime());
				ps.setString(9, aBlogEntry.id().key());
			}
		});
	}

	public void delete(BlogEntryId aBlogEntryId) {
		final String SQL = "DELETE FROM blogentry WHERE id=?";
		jdbcTemplate.update(SQL, aBlogEntryId.key());
	}

	public BlogEntry retrieve(BlogEntryId aBlogEntryId) {
		final String SQL = "SELECT * FROM blogentry WHERE id=?";
		List<BlogEntry> blogList = jdbcTemplate.query(SQL, new Object[] { aBlogEntryId.key() },
				new BlogEntryRowMapper());
		return blogList.size() > 0 ? blogList.get(0) : null;
	}

	class BlogEntryRowMapper implements RowMapper<BlogEntry> {
		@Override
		public BlogEntry mapRow(ResultSet rs, int i) throws SQLException {
			BlogEntryId blogEntryId = new BlogEntryId(rs.getString("id"));
			Title title = new Title(rs.getString("title"));
			Content content = new Content(rs.getString("content"));
			BlogEntryStatus status = BlogEntryStatus.create(rs.getInt("status"));
			int commentNumber = rs.getInt("commentnumber");
			BlogEntryComment blogEntryComment = new BlogEntryComment(commentNumber);
			BlogAuthor author = BlogMemberBuilder.buildAuthor(rs.getString("authorid"), rs.getString("authoraccount"),
					rs.getString("authorname"), true);
			Timestamp createTime = rs.getTimestamp("createtime");
			Timestamp modifyTime = rs.getTimestamp("modifytime");

			BlogEntry blogEntry = new BlogEntry();
			blogEntry.init(blogEntryId, title, content, author, status, blogEntryComment, createTime, modifyTime);
			return blogEntry;
		}

	}

}