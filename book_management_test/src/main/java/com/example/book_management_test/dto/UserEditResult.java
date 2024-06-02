package com.example.book_management_test.dto;

import com.example.book_management_test.constant.UserEditMessage;
import com.example.book_management_test.entity.UserInfo;

import lombok.Data;

/**
 * ユーザー編集結果DTOクラス
 * 
 * @author ys-fj
 *
 */
@Data
public class UserEditResult {

	/** ユーザー更新結果 */
	private UserInfo updateUserInfo;

	/** ユーザー更新結果メッセージEnum */
	private UserEditMessage updateMessage;
}
