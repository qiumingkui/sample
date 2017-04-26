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

import com.qiumingkui.sample.imedia.blog.domain.model.blogger.Blogger;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.BloggerId;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.BloggerPost;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.rank.BloggerRank;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.status.BloggerStatus;
import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogOwner;

@Service
public class BloggerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void create(Blogger aBlogger) {

		final String SQL = "INSERT INTO blogger(id,ownerid,owneraccount,ownername,postnumber,commentnumber,rank,status,createtime,modifytime) VALUES(?,?,?,?,?,?,?,?,?,?)";

		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, aBlogger.id().key());
				ps.setString(2, aBlogger.blogOwner().id());
				ps.setString(3, aBlogger.blogOwner().account());
				ps.setString(4, aBlogger.blogOwner().name());
				ps.setInt(5, aBlogger.bloggerPost().postNumber());
				ps.setInt(6, aBlogger.bloggerPost().commentNumber());
				ps.setInt(7, aBlogger.rank().code());
				ps.setInt(8, aBlogger.status().code());
				ps.setTimestamp(9, aBlogger.createTime());
				ps.setTimestamp(10, aBlogger.modifyTime());
			}
		});
	}

	public void update(Blogger aBlogger) {
		final String SQL = "UPDATE blogger SET ownerid=?,owneraccount=?,ownername=?,postnumber=?,commentnumber=?,rank=?,status=?,createtime=?,modifytime=? WHERE id=?";
		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, aBlogger.blogOwner().id());
				ps.setString(2, aBlogger.blogOwner().account());
				ps.setString(3, aBlogger.blogOwner().name());
				ps.setLong(4, aBlogger.bloggerPost().postNumber());
				ps.setLong(5, aBlogger.bloggerPost().commentNumber());
				ps.setInt(6, aBlogger.rank().code());
				ps.setInt(7, aBlogger.status().code());
				ps.setTimestamp(8, aBlogger.createTime());
				ps.setTimestamp(9, aBlogger.modifyTime());
				ps.setString(10, aBlogger.id().key());		
			}
		});
	}

	public void delete(BloggerId aBloggerId) {
		final String SQL = "DELETE FROM blogger WHERE id=?";
		jdbcTemplate.update(SQL, aBloggerId.key());
	}

	public Blogger retrieve(BloggerId aBloggerId) {
		final String SQL = "SELECT * FROM blogger WHERE id=?";
		List<Blogger> bloggerList = jdbcTemplate.query(SQL, new Object[] { aBloggerId.key() }, new BloggerRowMapper());
		return bloggerList.size() > 0 ? bloggerList.get(0) : null;
	}

	class BloggerRowMapper implements RowMapper<Blogger> {
		@Override
		public Blogger mapRow(ResultSet rs, int i) throws SQLException {
			BloggerId bloggerId = new BloggerId(rs.getString("id"));			
			BlogOwner blogOwner = new BlogOwner(rs.getString("ownerid"), rs.getString("owneraccount"), rs.getString("ownername"), true);
			BloggerPost bloggerPost = new BloggerPost(rs.getInt("postnumber"), rs.getInt("commentnumber"));
			BloggerRank bloggerRank = BloggerRank.create(rs.getInt("rank"));
			BloggerStatus bloggerStatus = BloggerStatus.create(rs.getInt("status"));
			Timestamp createTime = new Timestamp(rs.getLong("createtime"));
			Timestamp modifyTime = new Timestamp(rs.getLong("modifytime"));
			Blogger blogger = new Blogger(bloggerId, blogOwner, bloggerPost, bloggerRank, bloggerStatus, createTime,
					modifyTime);
			return blogger;
		}
	}

}
