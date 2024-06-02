package com.example.book_management_test.form;

import org.hibernate.validator.constraints.Length;

import com.example.book_management_test.constant.db.AuthorityKind;
import com.example.book_management_test.constant.db.UserStatusKind;

import lombok.Data;

/**
 * ユーザー登録画面Formクラス
 * 
 * @author ys-fj
 *
 */
@Data
public class UserListForm {

	/** ログインID */
	@Length(min = 8, max = 20)
	private String loginId;
	
	/** アカウント状態種別 */
	private UserStatusKind userStatusKind;

	/** ユーザー権限種別 */
	private AuthorityKind authorityKind;

	/** ユーザー一覧情報から選択されたログインID */
	private String selectedLoginId;

	/**
	 * ユーザー一覧情報から選択されたログインIDをクリアします。
	 * 
	 * @return ユーザー一覧情報から選択されたログインIDクリア後のインスタンス
	 */
	public UserListForm clearSelectedLoginId() {
		this.selectedLoginId = null;

		return this;
	}
}
