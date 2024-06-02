package com.example.book_management_dev.service;

import java.util.Optional;

import com.example.book_management_dev.dto.BookEditResult;
import com.example.book_management_dev.dto.BookUpdateInfo;
import com.example.book_management_dev.entity.BookInfo;

/**
 * 書籍編集画面Serviceインターフェース
 * 
 * @author ys-fj
 *
 */
public interface BookEditService {

	/**
	 * 書籍IDを使って書籍情報テーブルを検索し、検索結果を返却します。
	 * 
	 * @param bookId 書籍ID
	 * @return 該当の書籍情報テーブル登録情報
	 */
	public Optional<BookInfo> searchBookInfo(String bookId);

	/**
	 * 書籍情報テーブルを更新します。
	 * 
	 * @param bookUpdateInfo 書籍更新情報
	 * @return 更新結果
	 */
	public BookEditResult updateBookInfo(BookUpdateInfo bookUpdateInfo);

}
