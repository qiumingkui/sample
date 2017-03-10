package com.qiumingkui.ddd.sample.blog.domain.model;

import java.io.Serializable;

public class Comment implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CommentId commentId;
	
	private Content content;
	
}
