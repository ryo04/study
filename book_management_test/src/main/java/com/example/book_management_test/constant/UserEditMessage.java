package com.example.book_management_test.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ユーザー更新結果メッセージEnumクラス
 * 
 * @author ys-fj
 *
 */
@Getter
@AllArgsConstructor
public enum UserEditMessage {

	/** 更新成功 */
	SUCCEED(MessageConst.USEREDIT_UPDATE_SUCCEED),

	/** 更新失敗 */
	FAILED(MessageConst.USEREDIT_UPDATE_FAILED);

	/** メッセージID */
	private String messageId;
}
