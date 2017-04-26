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

import com.qiumingkui.sample.imedia.blog.domain.model.category.Category;
import com.qiumingkui.sample.imedia.blog.domain.model.category.CategoryId;
import com.qiumingkui.sample.imedia.blog.domain.model.category.CategoryVal;
import com.qiumingkui.sample.imedia.common.ext.version.ConcurrencyVersion;

@Service
public class CategoryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void create(Category aCategory) {

		final String SQL = "INSERT INTO category(id,pid,name,description,postnumber,versionnumber) VALUES(?,?,?,?,?,?)";

		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, aCategory.id().key());
				ps.setString(2, aCategory.parentId().key());
				ps.setString(3, aCategory.name());
				ps.setString(4, aCategory.description());
				ps.setLong(5, aCategory.categroyVal().postNumber());
				ps.setLong(6, aCategory.version().versionNumber());
			}
		});
	}

	public void update(Category aCategory) {
		final String SQL = "UPDATE category SET pid=?,name=?,description=?,postnumber=?,versionnumber=? WHERE id=?";
		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, aCategory.parentId().key());
				ps.setString(2, aCategory.name());
				ps.setString(3, aCategory.description());
				ps.setLong(4, aCategory.categroyVal().postNumber());
				ps.setLong(5, aCategory.version().versionNumber());
				ps.setString(6, aCategory.id().key());
			}
		});
	}

	public void delete(CategoryId aCategoryId) {
		final String SQL = "DELETE FROM category WHERE id=?";
		jdbcTemplate.update(SQL, aCategoryId.key());
	}

	public Category retrieve(CategoryId aCategoryId) {
		final String SQL = "SELECT * FROM category WHERE id=?";
		List<Category> categoryList = jdbcTemplate.query(SQL, new Object[] { aCategoryId.key() },
				new CategoryRowMapper());
		return categoryList.size() > 0 ? categoryList.get(0) : null;
	}

	class CategoryRowMapper implements RowMapper<Category> {
		@Override
		public Category mapRow(ResultSet rs, int i) throws SQLException {
			CategoryId id = new CategoryId(rs.getString("id"));
			CategoryId parentId = new CategoryId(rs.getString("pid"));
			String name = rs.getString("name");
			String description = rs.getString("description");
			CategoryVal categoryVal = new CategoryVal(rs.getLong("postnumber"));
			ConcurrencyVersion version = new ConcurrencyVersion(rs.getLong("versionnumber"));

			Category category = new Category(id, parentId, name, description, categoryVal, version);
			return category;
		}
	}

}
