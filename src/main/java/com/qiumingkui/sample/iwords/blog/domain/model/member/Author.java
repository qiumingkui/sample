package com.qiumingkui.sample.iwords.blog.domain.model.member;

public class Author extends Member{

	
	public Author(String aId, String aAccount, String aName, boolean aIsPermitted) {
		super(aId, aAccount, aName, aIsPermitted);
	}

//	public Author(Person person) {
//		super(person);
//	}
//
//	@Override
//	protected void initPermitted(Person aPerson) {
//		if(aPerson.isAdmin()||aPerson.isCommonUser()){
//			setPermitted(true);
//			return ;
//		}
//		setPermitted(false);
//	}

}
