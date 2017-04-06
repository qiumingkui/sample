package com.qiumingkui.sample.imedia.mp.domain.model.category;

import com.qiumingkui.sample.imedia.mp.domain.model.post.Post;
import com.qiumingkui.sample.imedia.mp.domain.model.post.PostId;

public interface CategoryRepository {

	public Post get(CategoryId aCategoryId);

	public void save(Category aCategory);

	public void del(CategoryId aCategoryId);

}
