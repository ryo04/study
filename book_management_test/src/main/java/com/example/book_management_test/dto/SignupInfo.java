package com.example.book_management_test.dto;

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
	
	/** 性別 */
	private String sex;
	
	/** 名前 */
	private String name;
	
	/** フリガナ */
	private String furigana;

}
