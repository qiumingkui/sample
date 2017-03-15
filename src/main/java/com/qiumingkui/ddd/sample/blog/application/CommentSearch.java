package com.qiumingkui.ddd.sample.blog.application;

import java.util.List;

public interface CommentSearch {


	/**
	 * 分页查询博客，按发布时间排序
	 * 
	 * @param aPageIndex
	 * @param aRows
	 * @return 页内博客ID列表
	 */
	public List<String> page(int aPageIndex, int aRows);

}
