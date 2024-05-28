package com.example.book_management_ver3.form;

import com.example.book_management_ver3.constant.db.BookStatusKind;

import lombok.Data;

/**
 * 書籍登録画面Formクラス
 * 
 * @author ys-fj
 *
 */
@Data
public class BookListForm {

	/** 書籍ID */
	private String bookId;

	/** 貸出状態種別 */
	private BookStatusKind bookStatusKind;

	/** 書籍一覧情報から選択された書籍ID */
	private String selectedBookId;

	/**
	 * 書籍一覧情報から選択された書籍IDをクリアします。
	 * 
	 * @return 書籍一覧情報から選択された書籍IDクリア後のインスタンス
	 */
	public BookListForm clearSelectedBookId() {
		this.selectedBookId = null;

		return this;
	}
}