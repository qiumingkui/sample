package com.qiumingkui.ddd.sample.user.domain.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.qiumingkui.ddd.sample.common.util.UtilDateTime;
import com.qiumingkui.ddd.sample.user.domain.model.role.Admin;
import com.qiumingkui.ddd.sample.user.domain.model.role.CommonUser;
import com.qiumingkui.ddd.sample.user.domain.model.role.Role;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserId userId;

	private String userName;

	private String password;

	private Set<Role> roles = new HashSet<Role>();

	private Timestamp createTime;

	private Timestamp modifyTime;

	private User() {
		super();
	}

	public User(UserId aUserId, String aUserName, String aPassword) {
		this();

		this.setUserId(aUserId);
		this.setUserName(aUserName);
		this.setPassword(aPassword);
		this.setCreateTime(UtilDateTime.nowTimestamp());
		this.setModifyTime(UtilDateTime.nowTimestamp());

		if (!(this.isCommonUser()||this.isAdmin())){
			this.assignCommonUser();
		}

	}

	public User(UserId aUserId, String aUserName, String aPassword, Set<Role> roles) {
		this();

		this.setUserId(aUserId);
		this.setUserName(aUserName);
		this.setPassword(aPassword);
		this.setCreateTime(UtilDateTime.nowTimestamp());
		this.setModifyTime(UtilDateTime.nowTimestamp());

		this.setRoles(roles);
		if (!(this.isCommonUser()||this.isAdmin())){
			this.assignCommonUser();
		}

	}

	public User(UserId aUserId, String aUserName, String aPassword, Set<Role> roles, Timestamp aCreateTime,
			Timestamp modifyTime) {
		this(aUserId, aUserName, aPassword);
		this.setCreateTime(aCreateTime);
		this.setModifyTime(modifyTime);
	}

	public UserId userId() {
		return userId;
	}

	public String userName() {
		return userName;
	}

	public String password() {
		return password;
	}

	public Timestamp createTime() {
		return createTime;
	}

	public boolean isAdmin() {
		for (Role role : roles) {
			if (role instanceof Admin) {
				return true;
			}
		}
		return false;
	}

	public boolean isCommonUser() {
		for (Role role : roles) {
			if (role instanceof CommonUser) {
				return true;
			}
		}
		return false;
	}

	public Timestamp modifyTime() {
		return modifyTime;
	}

	public void changeUserName(String userName) {
		this.setUserName(userName);
	}

	public void changePassword(String password) {
		this.setPassword(password);
	}

	public void assignAdmin() {
		for (Role role : roles) {
			if (role instanceof Admin) {
				return;
			}
		}
		roles.add(new Admin());
	}

	public void unassignAdmin() {
		for (Role role : roles) {
			if (role instanceof Admin) {
				roles.remove(role);
				return;
			}
		}
	}

	public void assignCommonUser() {
		for (Role role : roles) {
			if (role instanceof CommonUser) {
				return;
			}
		}
		roles.add(new CommonUser());
	}

	private void setUserId(UserId userId) {
		this.userId = userId;
	}

	private void setUserName(String userName) {
		this.userName = userName;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	private void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	private void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	private void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

}
