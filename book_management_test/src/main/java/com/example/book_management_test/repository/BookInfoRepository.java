package com.example.book_management_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book_management_test.constant.db.BookStatusKind;
import com.example.book_management_test.entity.BookInfo;

/**
 * 書籍情報テーブルRepositoryクラス
 * 
 * @author ys-fj
 *
 */
public interface BookInfoRepository extends JpaRepository<BookInfo, String> {

	/**
	 * 書籍IDの部分一致検索を行います。
	 * 
	 * @param bookName 書籍名
	 * @return 検索でヒットした書籍情報のリスト
	 */
	List<BookInfo> findByBookNameLike(String bookName);

	/**
	 * 書籍ID、貸出状態の項目を使って検索を行います。
	 * 
	 * <p>■検索条件
	 * <lu>
	 * <li>書籍ID：部分一致</li>
	 * <li>貸出状態：完全一致</li>
	 * </lu>
	 * <p>
	 * 
	 * @param bookName 書籍名
	 * @param bookStatusKind 貸出状態
	 * @return 検索でヒットした書籍情報のリスト
	 */
	List<BookInfo> findByBookNameLikeAndBookStatusKind(String bookName, BookStatusKind bookStatusKind);

}
