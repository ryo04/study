package com.example.book_management_dev.dto;

import com.example.book_management_dev.constant.db.BookStatusKind;

import lombok.Data;

/**
 * 書籍一覧画面検索用DTOクラス
 * 
 * @author ys-fj
 *
 */
@Data
public class BookSearchInfo {

	/** 書籍ID */
	private String bookName;

	/** 貸出状態種別 */
	private BookStatusKind bookStatusKind;

}
