package com.example.book_management_ver3.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ユーザー本登録結果種別
 * 
 * @author ys-fj
 */
@Getter
@AllArgsConstructor
public enum SignupConfirmStatus {

	/* DB更新エラー */
	FAILURE_BY_DB_ERROR(MessageConst.SIGNUP_DB_ERROR);

	String messageId;

}
