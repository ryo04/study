package com.example.book_management_ver3.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 処理結果種別
 * 
 * @author ys-fj
 */
@Getter
@AllArgsConstructor
public enum BookDeleteResult {

	/* エラーなし */
	SUCCEED(MessageConst.BOOKLIST_DELETE_SUCCEED),

	/* エラーあり */
	ERROR(MessageConst.BOOKLIST_NON_EXISTED_LOGIN_ID);

	/** メッセージID */
	private String messageId;

}
