package com.example.book_management_ver3.entity;

import java.time.LocalDateTime;

import com.example.book_management_ver3.constant.db.AuthorityKind;
import com.example.book_management_ver3.constant.db.UserStatusKind;
import com.example.book_management_ver3.entity.converter.UserAuthorityConverter;
import com.example.book_management_ver3.entity.converter.UserStatusConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ユーザー情報テーブルEntityクラス
 * 
 * @author ys-fj
 *
 */
@Entity
@Table(name = "userinf")
@Data
@AllArgsConstructor
public class UserInfo {

	/** ログインID */
	@Id
	@Column(name = "login_id")
	private String loginId;

	/** パスワード */
	private String password;

	/** ログイン失敗回数 */
	@Column(name = "login_failure_count")
	private int loginFailureCount = 0;

	/** アカウントロック日時 */
	@Column(name = "account_locked_time")
	private LocalDateTime accountLockedTime;

	/** ユーザー状態種別 */
	@Column(name = "is_disabled")
	@Convert(converter = UserStatusConverter.class)
	private UserStatusKind userStatusKind;

	/** ユーザー権限種別 */
	@Column(name = "authority")
	@Convert(converter = UserAuthorityConverter.class)
	private AuthorityKind authorityKind;
	
	/** 性別*/
	@Column(name = "sex")
	private String sex;

	/** 本登録完了有無(仮登録状態ならfalse)*/
	@Column(name = "is_signup_completed")
	private boolean signupCompleted;

	/** 登録日時 */
	@Column(name = "create_time")
	private LocalDateTime createTime;

	/** 最終更新日時 */
	@Column(name = "update_time")
	private LocalDateTime updateTime;

	/** 最終更新ユーザ */
	@Column(name = "update_user")
	private String updateUser;
	
	/** 最終更新ユーザ */
	@Column(name = "name")
	private String name;
	
	/** 最終更新ユーザ */
	@Column(name = "furigana")
	private String furigana;

	/**
	 * デフォルトコンストラクタ
	 */
	public UserInfo() {
	}

	/**
	 * ログイン失敗回数をインクリメントします。
	 * 
	 * @return ログイン失敗回数がインクリメントされた、自身のインスタンス
	 */
	public UserInfo incrementLoginFailureCount() {
		return new UserInfo(loginId, password, ++loginFailureCount, accountLockedTime, userStatusKind,
				authorityKind, sex, signupCompleted, createTime, updateTime, updateUser, name, furigana);
	}

	/**
	 * ログイン失敗情報をリセットします。
	 * 
	 * @return ログイン失敗情報がリセットされた、自身のインスタンス
	 */
	public UserInfo resetLoginFailureInfo() {
		return new UserInfo(loginId, password, 0, null, userStatusKind,
				authorityKind, sex, signupCompleted, createTime, updateTime, updateUser, name, furigana);
	}

	/**
	 * ログイン失敗回数、アカウントロック日時を更新し、アカウントロック状態に更新します。
	 * 
	 * @return ログイン失敗回数、アカウントロック日時が更新された、自身のインスタンス
	 */
	public UserInfo updateAccountLocked() {
		return new UserInfo(loginId, password, 0, LocalDateTime.now(), userStatusKind, 
				authorityKind, sex, signupCompleted, createTime, updateTime, updateUser, name, furigana);
	}

}
