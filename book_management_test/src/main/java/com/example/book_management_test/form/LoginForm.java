package com.example.book_management_test.form;

import lombok.Data;

/**
 * ログイン画面Formクラス
 * 
 * @author ys-fj
 *
 */
@Data
public class LoginForm {

	/** ログインID */
	private String loginId;

	/** パスワード */
	private String password;
}
