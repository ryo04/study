package com.example.book_management_dev.form;

import com.example.book_management_dev.constant.db.BookStatusKind;

import lombok.Data;

/**
 * 書籍編集画面Formクラス
 * 
 * @author ys-fj
 *
 */
@Data
public class BookEditForm {

	/** 貸出状態種別 */
	private BookStatusKind bookStatusKind;

}
