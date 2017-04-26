package com.qiumingkui.sample.imedia.blog.port.adapter.persistence.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiumingkui.sample.imedia.blog.domain.model.category.CategoryRepository;
import com.qiumingkui.sample.imedia.blog.domain.model.category.Category;
import com.qiumingkui.sample.imedia.blog.domain.model.category.CategoryId;
import com.qiumingkui.sample.imedia.blog.port.adapter.persistence.dao.CategoryDao;

@Service
public class JdbcCategoryRepository implements CategoryRepository {
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Category get(CategoryId aCategoryId) {
		return categoryDao.retrieve(aCategoryId);
	}

	@Override
	public void save(Category aCategory) {
		Category retrieveCategory = categoryDao.retrieve(aCategory.id());
		if (retrieveCategory != null) {
			categoryDao.update(aCategory);
		} else {
			categoryDao.create(aCategory);
		}

	}

	@Override
	public void del(CategoryId aCategoryId) {
		categoryDao.delete(aCategoryId);
	}
}
