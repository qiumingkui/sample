package com.qiumingkui.sample.imedia.common.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qiumingkui.sample.imedia.common.domain.model.DomainEvent;

public class MemoryEventStore implements EventStore {

	private static long storedEventNumber = 0;
	
	private static Map<String, StoredEvent> cache = new HashMap<String, StoredEvent>();
	
	private static synchronized long genStoredEventNumber(){
		return storedEventNumber++;
	}
	
	public List<StoredEvent> allStoredEventsBetween(long aLowStoredEventId, long aHighStoredEventId) {
		List<StoredEvent> list = new ArrayList<StoredEvent>(cache.values());
		return list;
	}

	public List<StoredEvent> allStoredEventsSince(long aStoredEventId) {
		List<StoredEvent> list = new ArrayList<StoredEvent>(cache.values());
		return list;
	}

	public StoredEvent append(DomainEvent aDomainEvent) {
		String eventSerialization =
                EventSerializer.instance().serialize(aDomainEvent);

		long eventId = genStoredEventNumber();
		
        StoredEvent storedEvent =
                new StoredEvent(
                        aDomainEvent.getClass().getName(),
                        aDomainEvent.occurredOn(),
                        eventSerialization,eventId);

        cache.put(String.valueOf(eventId), storedEvent);

        return storedEvent;
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public long countStoredEvents() {
		
		return cache.values().size();
	}

}
