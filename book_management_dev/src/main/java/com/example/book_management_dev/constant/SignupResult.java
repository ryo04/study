package com.example.book_management_dev.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ユーザー登録結果種別
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
	FAILURE_BY_DB_ERROR(MessageConst.SIGNUP_DB_ERROR),
	
	/* 性別の未入力 */
	SEX_MEPTY(MessageConst.SIGNUP_SEX_EMPTY),
	
	/* 名前の未入力 */
	NAME_MEPTY(MessageConst.SIGNUP_NAME_EMPTY),
	
	/* フリガナの未入力 */
	FURIGANA_MEPTY(MessageConst.SIGNUP_FURIGANA_EMPTY);

	String messageId;

}
