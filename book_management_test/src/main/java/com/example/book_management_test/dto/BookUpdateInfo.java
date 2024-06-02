package com.example.book_management_test.dto;

import com.example.book_management_test.constant.db.BookStatusKind;

import lombok.Data;

/**
 * 書籍更新情報DTOクラス
 * 
 * @author ys-fj
 *
 */
@Data
public class BookUpdateInfo {

	/** 書籍ID */
	private String bookId;

	/** 貸出状態種別 */
	private BookStatusKind bookStatusKind;

//	/** 更新ユーザーID */
//	private String updateUser;
	
	/** 更新ユーザーID */
	private String updateBookId;
	
	
}
