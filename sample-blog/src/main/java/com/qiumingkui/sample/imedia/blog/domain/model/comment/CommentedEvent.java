package com.qiumingkui.sample.imedia.blog.domain.model.comment;

import java.io.Serializable;
import java.util.Date;

import com.qiumingkui.sample.imedia.blog.domain.model.Content;
import com.qiumingkui.sample.imedia.common.domain.model.DomainEvent;

public class CommentedEvent implements DomainEvent, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private long storedEventId;

	private CommentId commentId;

	private Content content;

	private int eventVersion;

	private Date occurredOn;

	public CommentedEvent(CommentId aCommentId, Content aContent, Date aOccurredOn) {
		super();
//		this.storedEventId = aStoredEventId;
		this.commentId = aCommentId;
		this.content = aContent;
		this.occurredOn = aOccurredOn;
	}

//	public long storedEventId() {
//		return storedEventId;
//	}

	public CommentId commentId() {
		return commentId;
	}

	public Content content() {
		return content;
	}

	public int eventVersion() {
		return this.eventVersion;
	}

	public Date occurredOn() {
		return this.occurredOn;
	}

}
