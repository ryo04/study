package com.example.book_management_dev.dto;

import com.example.book_management_dev.constant.UserEditMessage;
import com.example.book_management_dev.entity.UserInfo;

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
