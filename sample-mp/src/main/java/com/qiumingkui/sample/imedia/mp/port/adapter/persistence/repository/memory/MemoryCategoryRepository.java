package com.qiumingkui.sample.imedia.mp.port.adapter.persistence.repository.memory;

import com.qiumingkui.sample.imedia.common.domain.version.ConcurrencyVersion;
import com.qiumingkui.sample.imedia.mp.domain.model.category.Category;
import com.qiumingkui.sample.imedia.mp.domain.model.category.CategoryId;
import com.qiumingkui.sample.imedia.mp.domain.model.category.CategoryPostVal;
import com.qiumingkui.sample.imedia.mp.domain.model.category.CategoryRepository;
import com.qiumingkui.sample.imedia.mp.domain.model.post.Post;

public class MemoryCategoryRepository implements CategoryRepository {

	@Override
	public Post get(CategoryId aCategoryId) {
		// TODO Auto-generated method stub
		CategoryWithVersion category = new CategoryWithVersion();
		category.init(null, null, null, null, null, null);
		return null;
		
	}

	@Override
	public void save(Category aCategory) {
		// TODO Auto-generated method stub

	}

	@Override
	public void del(CategoryId aCategoryId) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("serial")
	class CategoryWithVersion extends Category {
		public void init(CategoryId aId, CategoryId aParentId, String aName, String aDescription,
				CategoryPostVal aPostVal, ConcurrencyVersion aVersion) {
			this.init(aId, aParentId, aName, aDescription, aPostVal, aVersion);
		}
	}
}
