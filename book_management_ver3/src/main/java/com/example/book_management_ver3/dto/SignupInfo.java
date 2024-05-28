package com.example.book_management_ver3.dto;

import lombok.Data;

/**
 * ユーザー登録用DTOクラス
 * 
 * @author ys-fj
 *
 */
@Data
public class SignupInfo {

	/** ログインID */
	private String loginId;

	/** パスワード */
	private String password;

}
