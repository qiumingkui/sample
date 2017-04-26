package com.qiumingkui.sample.imedia.blog.domain.model.category;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.sample.imedia.blog.domain.model.category.Category;
import com.qiumingkui.sample.imedia.blog.domain.model.category.CategoryId;
import com.qiumingkui.sample.imedia.blog.domain.model.category.CategoryRepository;
import com.qiumingkui.sample.imedia.blog.helper.CategoryTestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository categoryRepository;

	private Category aCategory;
	private CategoryId aCategoryId;

	@Before
	// @Transactional
	public void sava4Create() {
		aCategory = CategoryTestHelper.buildCategoryExample();
		aCategoryId = aCategory.id();
		categoryRepository.save(aCategory);

		Category category = categoryRepository.get(aCategoryId);
		assertThat(category != null && category.id().key().equals(aCategoryId.key())).isTrue();
	}

	@Test
	// @Transactional
	public void get() {
		Category category = categoryRepository.get(aCategoryId);
		assertThat(category != null && category.id().key().equals(aCategoryId.key())).isTrue();
	}

	@Test
	// @Transactional
	public void save4Update() {
		Category category = categoryRepository.get(aCategory.id());
		String description = "category" + " : this is new :" + new Date();
		category.changeDescription(description);
		categoryRepository.save(category);

		category = categoryRepository.get(aCategory.id());
		assertThat(category.description().equals(description)).isTrue();
	}

	@Test
	// @Transactional
	public void del() {
		categoryRepository.del(aCategoryId);
		Category component = categoryRepository.get(aCategoryId);
		assertThat(component == null).isTrue();
	}

}
