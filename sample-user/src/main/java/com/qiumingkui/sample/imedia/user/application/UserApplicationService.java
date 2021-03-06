package com.qiumingkui.sample.imedia.user.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.sample.imedia.user.domain.model.AuthenticateResult;
import com.qiumingkui.sample.imedia.user.domain.model.PasswordServcie;
import com.qiumingkui.sample.imedia.user.domain.model.User;
import com.qiumingkui.sample.imedia.user.domain.model.UserData;
import com.qiumingkui.sample.imedia.user.domain.model.UserFactory;
import com.qiumingkui.sample.imedia.user.domain.model.UserId;
import com.qiumingkui.sample.imedia.user.port.adapter.persistence.repository.UserRepository;

@Service
public class UserApplicationService {

	@Autowired
	private UserRepository userRepository;

	// @Transactional
	public String regist(String aAccount, String aNickname, String aRealname, String aPassword) {
		User user = UserFactory.create(aAccount, aNickname, aRealname, aPassword);
		userRepository.save(user);
		return user.id().key();
	}

	// @Transactional
	public AuthenticateResult authenticate(String account, String password) {
		User user = userRepository.getUserByAccount(account);
		String encryptedPassword = PasswordServcie.encryptPassword(password);
		if (user.password().equals(encryptedPassword)) {
			return new AuthenticateResult(true);
		}
		return new AuthenticateResult(false);
	}

	// @Transactional
	public UserData getUserByAccount(String account) {
		User user = userRepository.getUserByAccount(account);
		UserData userData = new UserData(user);
		return userData;
	}

	// @Transactional
	public UserData getUserById(String userId) {
		User user = userRepository.get(new UserId(userId));
		if (user == null) {
			return null;
		}
		UserData userData = new UserData(user);
		return userData;
	}

	// @Transactional
	public void changePassword(String aUserId, String aPassword) {
		String encryptedPassword = PasswordServcie.encryptPassword(aPassword);
		User user = userRepository.get(new UserId(aUserId));
		user.changePassword(encryptedPassword);
		userRepository.save(user);
	}

	// @Transactional
	public void changeNickname(String aUserId, String aNickname) {
		User user = userRepository.get(new UserId(aUserId));
		user.changeNickname(aNickname);
		userRepository.save(user);
	}

	// @Transactional
	public void changeRealname(String aUserId, String aRealname) {
		User user = userRepository.get(new UserId(aUserId));
		user.changeRealname(aRealname);
		userRepository.save(user);
	}

	// @Transactional
	public void assignAdmin(String aUserId) {
		User user = userRepository.get(new UserId(aUserId));
		user.assignAdmin();
		userRepository.save(user);
	}

	// @Transactional
	public void unassignAdmin(String aUserId) {
		User user = userRepository.get(new UserId(aUserId));
		user.unassignAdmin();
		userRepository.save(user);
	}

	// @Transactional
	public void assignUser(String aUserId) {
		User user = userRepository.get(new UserId(aUserId));
		user.assignUser();
		userRepository.save(user);
	}

	@Transactional
	public void removeUser(String aUserId) {
		UserId userId = new UserId(aUserId);
		userRepository.del(userId);
	}
}
