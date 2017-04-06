package com.qiumingkui.sample.imedia.mp.domain.model.category;

import java.io.Serializable;

public class PostCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PostCategoryId postCategoryId;
	
	
	private PostCategory() {
		super();
	}



	public PostCategory(PostCategoryId aPostCategoryId) {
		this();
		this.setPostCategoryId(aPostCategoryId);
	}



	public PostCategoryId postCategoryId() {
		return postCategoryId;
	}



	private void setPostCategoryId(PostCategoryId aPostCategoryId) {
		this.postCategoryId = aPostCategoryId;
	}
	
	

}
