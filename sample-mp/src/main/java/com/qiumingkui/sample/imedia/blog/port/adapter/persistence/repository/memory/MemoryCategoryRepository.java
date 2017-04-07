package com.qiumingkui.sample.imedia.blog.port.adapter.persistence.repository.memory;

import java.util.HashMap;
import java.util.Map;

import com.qiumingkui.sample.imedia.blog.domain.model.category.Category;
import com.qiumingkui.sample.imedia.blog.domain.model.category.CategoryId;
import com.qiumingkui.sample.imedia.blog.domain.model.category.CategoryRepository;

public class MemoryCategoryRepository implements CategoryRepository {

	private static Map<String, Category> cache = new HashMap<String, Category>();

	@Override
	public Category get(CategoryId aCategoryId) {
		return cache.get(aCategoryId.key());
	}

	@Override
	public void save(Category aCategory) {
		cache.put(aCategory.id().key(), aCategory);
	}

	@Override
	public void del(CategoryId aCategoryId) {
		cache.remove(aCategoryId.key());
	}

}
