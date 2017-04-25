package com.qiumingkui.sample.imedia.common.event;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.qiumingkui.sample.imedia.common.domain.model.DomainEvent;

@Service
public class JdbcEventStore implements EventStore {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<StoredEvent> allStoredEventsBetween(long aLowStoredEventId, long aHighStoredEventId) {
		final String SQL = "SELECT * FROM storedevent WHERE eventid>=? and eventid<=? ORDER BY eventid";
		List<StoredEvent> storedEventList = jdbcTemplate.query(SQL,
				new Object[] { aLowStoredEventId, aHighStoredEventId }, new StoredEventRowMapper());
		return storedEventList;
	}

	@Override
	public List<StoredEvent> allStoredEventsSince(long aStoredEventId) {
		List<StoredEvent> storedEventList = allStoredEventsBetween(aStoredEventId, aStoredEventId);
		return storedEventList;
	}

	@Override
	public StoredEvent append(DomainEvent aDomainEvent) {
		String eventSerialization = EventSerializer.instance().serialize(aDomainEvent);

		StoredEvent storedEvent = new StoredEvent(aDomainEvent.getClass().getName(), aDomainEvent.occurredOn(),
				eventSerialization);

		final String SQL = "INSERT INTO storedevent(typename,eventbody,occurredon) VALUES(?,?,?)";
		jdbcTemplate.update(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, storedEvent.typeName());
				ps.setString(2, storedEvent.eventBody());
				ps.setDate(3, new Date(storedEvent.occurredOn().getTime()));
			}
		});
		return storedEvent;
	}

	@Override
	public void close() {

	}

	@Override
	public long countStoredEvents() {
		final String SQL = "SELECT count(1) as countval FROM storedevent";
		if (jdbcTemplate == null)
			return -1;
		String countValStr = jdbcTemplate.queryForObject(SQL, String.class);
		Long countVal = new Long(countValStr);
		return countVal;
	}

	class StoredEventRowMapper implements RowMapper<StoredEvent> {

		@Override
		public StoredEvent mapRow(ResultSet rs, int rowNum) throws SQLException {

			StoredEvent storedEvent = new StoredEvent(rs.getString("typename"), rs.getDate("occurredon"),
					rs.getString("eventbody"), rs.getLong("eventid"));
			return storedEvent;
		}

	}

}
