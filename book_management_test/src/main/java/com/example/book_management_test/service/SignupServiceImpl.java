package com.example.book_management_test.service;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.book_management_test.constant.SignupResult;
import com.example.book_management_test.constant.db.AuthorityKind;
import com.example.book_management_test.constant.db.UserStatusKind;
import com.example.book_management_test.dto.SignupInfo;
import com.example.book_management_test.entity.UserInfo;
import com.example.book_management_test.repository.UserInfoRepository;

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
		}

		var signupInfo = editSignupInfo(dto);
		try {
			if(signupInfo.getSex() == null || signupInfo.getSex() == "") {
				return SignupResult.SEX_MEPTY;
			}else if(signupInfo.getName() == null || signupInfo.getName() == "") {
				return SignupResult.NAME_MEPTY;
			}else if(signupInfo.getFurigana() == null || signupInfo.getFurigana() == "") {
				return SignupResult.FURIGANA_MEPTY;
			}
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
		userInfo.setSex(dto.getSex());
		userInfo.setUserStatusKind(UserStatusKind.ENABLED);
		userInfo.setAuthorityKind(AuthorityKind.ITEM_WATCHER);
		userInfo.setSignupCompleted(true); // 仮登録処理が必要になったら true から false に変える
		userInfo.setCreateTime(LocalDateTime.now());
		userInfo.setUpdateTime(LocalDateTime.now());
		userInfo.setUpdateUser(dto.getName());
		userInfo.setName(dto.getName());
		userInfo.setFurigana(dto.getFurigana());

		return userInfo;
	}

}
