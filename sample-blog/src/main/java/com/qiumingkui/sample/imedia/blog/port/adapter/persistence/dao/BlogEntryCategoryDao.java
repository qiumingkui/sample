package com.qiumingkui.sample.imedia.blog.port.adapter.persistence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.qiumingkui.sample.imedia.blog.domain.model.category.BlogEntryCategory;
import com.qiumingkui.sample.imedia.blog.domain.model.category.BlogEntryCategoryId;

@Service
public class BlogEntryCategoryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void create(BlogEntryCategory aBlogEntryCategory) {

		final String SQL = "INSERT INTO blogentrycategory(blogentryid,categoryid) VALUES(?,?)";

		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, aBlogEntryCategory.id().blogEntryId());
				ps.setString(2, aBlogEntryCategory.id().categoryId());
			}
		});
	}

	public void delete(BlogEntryCategoryId aBlogEntryCategoryId) {
		final String SQL = "DELETE FROM blogentrycategory WHERE blogentryid=? and categoryid=?";

		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, aBlogEntryCategoryId.blogEntryId());
				ps.setString(2, aBlogEntryCategoryId.categoryId());
			}
		});
	}

	public BlogEntryCategory retrieve(BlogEntryCategoryId aBlogEntryCategoryId) {
		final String SQL = "SELECT * FROM blogentrycategory WHERE blogentryid=? and categoryid=?";
		List<BlogEntryCategory> categoryList = jdbcTemplate.query(SQL,
				new Object[] { aBlogEntryCategoryId.blogEntryId(), aBlogEntryCategoryId.categoryId() },
				new BlogEntryCategoryRowMapper());
		return categoryList.size() > 0 ? categoryList.get(0) : null;
	}

	class BlogEntryCategoryRowMapper implements RowMapper<BlogEntryCategory> {
		@Override
		public BlogEntryCategory mapRow(ResultSet rs, int i) throws SQLException {
			BlogEntryCategoryId id = new BlogEntryCategoryId(rs.getString("blogentryid"), rs.getString("categoryid"));
			BlogEntryCategory category = new BlogEntryCategory(id);
			return category;
		}
	}

}
