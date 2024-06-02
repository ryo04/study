package com.example.book_management_test.service;

import java.util.List;

import com.example.book_management_test.constant.BookDeleteResult;
import com.example.book_management_test.dto.BookListInfo;
import com.example.book_management_test.dto.BookSearchInfo;

/**
 * 書籍一覧画面Serviceインターフェース
 * 
 * @author ys-fj
 *
 */
public interface BookListService {

	/**
	 * 書籍情報テーブルを全件検索し、書籍一覧画面に必要な情報へ変換して返却します。
	 * 
	 * @return 書籍情報テーブルの全登録情報
	 */
	public List<BookListInfo> editBookList();

	/**
	 * 書籍情報を条件検索した結果を画面の表示用に変換して返却します。
	 * 
	 * @param dto 検索に使用するパラメーター
	 * @return 検索結果
	 */
	public List<BookListInfo> editBookListByParam(BookSearchInfo dto);

	/**
	 * 指定されたIDの書籍情報を削除します。
	 * 
	 * @param bookId 書籍ID
	 * @return 実行結果(エラー有無)
	 */
	public BookDeleteResult deleteBookInfoById(String bookId);
}
