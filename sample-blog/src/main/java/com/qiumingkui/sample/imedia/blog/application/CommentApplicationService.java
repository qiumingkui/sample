package com.qiumingkui.sample.imedia.blog.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.sample.imedia.blog.domain.model.comment.Comment;
import com.qiumingkui.sample.imedia.blog.domain.model.comment.CommentData;
import com.qiumingkui.sample.imedia.blog.domain.model.comment.CommentFactory;
import com.qiumingkui.sample.imedia.blog.domain.model.comment.CommentId;
import com.qiumingkui.sample.imedia.blog.domain.model.comment.CommentRepository;
import com.qiumingkui.sample.imedia.common.domain.event.DomainEvent;
import com.qiumingkui.sample.imedia.common.domain.event.DomainEventPublisher;
import com.qiumingkui.sample.imedia.common.domain.event.DomainEventSubscriber;
import com.qiumingkui.sample.imedia.common.domain.event.EventStore;
import com.qiumingkui.sample.imedia.common.domain.event.MemoryEventStore;

@Service
public class CommentApplicationService {

	@Autowired
	private CommentRepository commentRepository;

	private EventStore eventStore=new MemoryEventStore();
	
	/**
	 * 发表评论
	 * 
	 * @param aBlogId
	 * @param aContent
	 * @return
	 */
	// @Transactional
	public String publishComment(String aBlogId, String aContent) {
		DomainEventPublisher
        .instance()
        .subscribe(new DomainEventSubscriber<DomainEvent>() {

            public void handleEvent(DomainEvent aDomainEvent) {
            	eventStore.append(aDomainEvent);
            }

            public Class<DomainEvent> subscribedToEventType() {
                return DomainEvent.class; // all domain events
            }
        });
		
		Comment comment = CommentFactory.create(aBlogId, aContent);
		commentRepository.save(comment);
		return comment.id().key();
	}

	public CommentData readComment(String aCommentId) {
		CommentId commentId = new CommentId(aCommentId);
		Comment comment = commentRepository.get(commentId);
		CommentData commentData = new CommentData(comment.id().key(), comment.id().key(),
				comment.content().contentTxt(), comment.createTime());
		return commentData;
	}


}
