package com.qiumingkui.sample.imedia.mp.domain.model.blogger;

import com.qiumingkui.sample.imedia.common.util.UUIDUtil;
import com.qiumingkui.sample.imedia.mp.domain.model.member.Owner;

public class BloggerFactory {

	public static Blogger build(Owner aOwner) {
		final String BLOGGER_ID = UUIDUtil.gen();
		BloggerId id = new BloggerId(BLOGGER_ID);
		return new Blogger().create(id, aOwner);
	}

}
