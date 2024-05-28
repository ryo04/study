package com.example.book_management_ver3.service;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.book_management_ver3.constant.SignupResult;
import com.example.book_management_ver3.constant.db.AuthorityKind;
import com.example.book_management_ver3.constant.db.UserStatusKind;
import com.example.book_management_ver3.dto.SignupInfo;
import com.example.book_management_ver3.entity.UserInfo;
import com.example.book_management_ver3.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * ユーザー登録画面Service実装クラス
 * 
 * @author ys-fj
 *
 */
@Service
@RequiredArgsConstructor
public class SignupServiceImpl implements SignupService {

//	/** メール送信Serviceクラス */
//	private final MailSendService mailSendService;

	/** ユーザー情報テーブルRepositoryクラス */
	private final UserInfoRepository repository;

	/** パスワードエンコーダー */
	private final PasswordEncoder passwordEncoder;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SignupResult signup(SignupInfo dto) {
		var userInfoOpt = repository.findById(dto.getLoginId());
		if (userInfoOpt.isPresent()) {
			var userInfo = userInfoOpt.get();
			if (userInfo.isSignupCompleted()) {
				return SignupResult.FAILURE_BY_ALREADY_COMPLETED;
			}

//			return SignupResult.FAILURE_BY_SIGNUP_PROCEEDING;
		}

		var signupInfo = editSignupInfo(dto);
		try {
			repository.save(signupInfo);
		} catch (Exception e) {
			return SignupResult.FAILURE_BY_DB_ERROR;
		}

		return SignupResult.SUCCEED;
	}

	/**
	 * ユーザー登録情報を作成する。
	 * 
	 * @param dto ユーザー登録画面Service入力情報
	 * @return ユーザー登録情報
	 */
	private UserInfo editSignupInfo(SignupInfo dto) {
		var userInfo = new UserInfo();
		userInfo.setLoginId(dto.getLoginId());
		userInfo.setPassword(passwordEncoder.encode(dto.getPassword()));
		userInfo.setUserStatusKind(UserStatusKind.ENABLED);
		userInfo.setAuthorityKind(AuthorityKind.ITEM_WATCHER);
		userInfo.setSignupCompleted(false);
		userInfo.setCreateTime(LocalDateTime.now());
		userInfo.setUpdateTime(LocalDateTime.now());
		userInfo.setUpdateUser(dto.getLoginId());

		return userInfo;
	}

}