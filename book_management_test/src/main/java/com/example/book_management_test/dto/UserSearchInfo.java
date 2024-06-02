package com.example.book_management_test.dto;

import com.example.book_management_test.constant.db.AuthorityKind;
import com.example.book_management_test.constant.db.UserStatusKind;

import lombok.Data;

/**
 * ユーザー一覧画面検索用DTOクラス
 * 
 * @author ys-fj
 *
 */
@Data
public class UserSearchInfo {

	/** ログインID */
	private String loginId;

	/** アカウント状態種別 */
	private UserStatusKind userStatusKind;

	/** ユーザー権限種別 */
	private AuthorityKind authorityKind;

}
