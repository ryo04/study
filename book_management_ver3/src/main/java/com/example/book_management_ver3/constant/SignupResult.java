package com.example.book_management_ver3.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ユーザー仮登録結果種別
 * 
 * @author ys-fj
 */
@Getter
@AllArgsConstructor
public enum SignupResult {

	/* エラーなし */
	SUCCEED(MessageConst.SIGNUP_TENTATIVE_SUCCEED),

	/* 既に本登録済み */
	FAILURE_BY_ALREADY_COMPLETED(MessageConst.SIGNUP_ALREADY_COMPLETED),

	/* DB更新エラー */
	FAILURE_BY_DB_ERROR(MessageConst.SIGNUP_DB_ERROR);

	String messageId;

}
