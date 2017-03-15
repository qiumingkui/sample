package com.qiumingkui.ddd.sample.blog.application;

import java.util.List;

public interface BlogSearch {

	/**
	 * 列出置顶博客ID
	 * 
	 * @return 置顶博客ID
	 */
	public String getTop();

	/**
	 * 列出最热博客ID列表
	 * 
	 * @return 最热博客ID列表
	 */
	public List<String> listHot();

	/**
	 * 分页查询博客，按发布时间排序
	 * 
	 * @param aPageIndex
	 * @param aRows
	 * @return 页内博客ID列表
	 */
	public List<String> page(int aPageIndex, int aRows);

	/**
	 * 分页查询博客，按评论总数排序
	 * 
	 * @param aPageIndex
	 *            分页序号
	 * @param aRows
	 *            页行数
	 * @return 页内博客ID列表
	 */
	public List<String> pageOrderByCommentNumber(int aPageIndex, int aRows);

	/**
	 * 分页查询博客，按最新评论时间排序
	 * 
	 * @param aPageIndex
	 *            分页序号
	 * @param aRows
	 *            页行数
	 * @return 页内博客ID列表
	 */
	public List<String> pageOrderByCommentTime(int aPageIndex, int aRows);

	/**
	 * 全文检索博客
	 * 
	 * @param aKeyWords
	 *            关键词
	 * @param aPageIndex
	 *            分页序号
	 * @param aRows
	 *            页行数
	 * @return 页内博客ID列表
	 */
	public List<String> findByKeyWords(String aKeyWords, int aPageIndex, int aRows);
}
