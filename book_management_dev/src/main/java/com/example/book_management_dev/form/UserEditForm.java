package com.example.book_management_dev.form;

import com.example.book_management_dev.constant.db.AuthorityKind;
import com.example.book_management_dev.constant.db.UserStatusKind;

import lombok.Data;

/**
 * ユーザー編集画面Formクラス
 * 
 * @author ys-fj
 *
 */
@Data
public class UserEditForm {

	/** ログイン失敗状況をリセットするか(リセットするならtrue) */
	private boolean resetsLoginFailure;

	/** アカウント状態種別 */
	private UserStatusKind userStatusKind;

	/** ユーザー権限種別 */
	private AuthorityKind authorityKind;

}
