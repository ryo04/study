package com.example.book_management_ver3.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 書籍更新結果メッセージEnumクラス
 * 
 * @author ys-fj
 *
 */
@Getter
@AllArgsConstructor
public enum BookEditMessage {

	/** 更新成功 */
	SUCCEED(MessageConst.BOOKEDIT_UPDATE_SUCCEED),

	/** 更新失敗 */
	FAILED(MessageConst.BOOKEDIT_UPDATE_FAILED);

	/** メッセージID */
	private String messageId;
}
