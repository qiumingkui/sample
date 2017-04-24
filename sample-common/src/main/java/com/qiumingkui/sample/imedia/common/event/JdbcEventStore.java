package com.qiumingkui.sample.imedia.common.event;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.qiumingkui.sample.imedia.common.domain.model.DomainEvent;

public class JdbcEventStore implements EventStore{

	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public List<StoredEvent> allStoredEventsBetween(long aLowStoredEventId, long aHighStoredEventId) {
		final String SQL = "SELECT * FROM storedevent WHERE id=?";
		List<StoredEvent> blogList = jdbcTemplate.query(SQL, new Object[] { aLowStoredEventId, aHighStoredEventId },
				new StoredEventRowMapper());
		return null;
	}

	public List<StoredEvent> allStoredEventsSince(long aStoredEventId) {
		// TODO Auto-generated method stub
		return null;
	}

	public StoredEvent append(DomainEvent aDomainEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public long countStoredEvents() {
		// TODO Auto-generated method stub
		return 0;
	}

	class StoredEventRowMapper implements RowMapper<StoredEvent>{

		@Override
		public StoredEvent mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}
