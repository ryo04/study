package com.example.book_management_ver3.entity;

import java.time.LocalDateTime;

import com.example.book_management_ver3.constant.db.BookStatusKind;
import com.example.book_management_ver3.entity.converter.BookStatusConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 書籍情報テーブルEntityクラス
 * 
 * @author ys-fj
 *
 */
@Entity
@Table(name = "bookinf")
@Data
@AllArgsConstructor
public class BookInfo {

	/** 書籍ID */
	@Id
	@Column(name = "book_id")
	private String bookId;
	
	/** 書籍名 */
	@Column(name = "book_name")
	private String bookName;
	
	/** 所有者 */
	@Column(name = "holder")
	private String holder;

	/** 貸出状態種別 */
	@Column(name = "lending_flg")
	@Convert(converter = BookStatusConverter.class)
	private BookStatusKind bookStatusKind;
	
	/** カテゴリー */
	@Column(name = "category")
	private String category;

	/** 貸出日時 */
	@Column(name = "rented_time")
	private LocalDateTime rentedTime;

	/** 登録日時 */
	@Column(name = "create_time")
	private LocalDateTime createTime;

	/** 最終更新日時 */
	@Column(name = "update_time")
	private LocalDateTime updateTime;

	/** 最終更新ユーザ */
	@Column(name = "update_user")
	private String updateUser;

	/**
	 * デフォルトコンストラクタ
	 */
	public BookInfo() {
	}

//	/**
//	 * ログイン失敗回数をインクリメントします。
//	 * 
//	 * @return ログイン失敗回数がインクリメントされた、自身のインスタンス
//	 */
//	public BookInfo incrementLoginFailureCount() {
//		return new BookInfo(bookId, bookName, holder, bookStatusKind, category, 
//				rentedTime, createTime, updateTime, updateUser);
//	}
//
//	/**
//	 * ログイン失敗情報をリセットします。
//	 * 
//	 * @return ログイン失敗情報がリセットされた、自身のインスタンス
//	 */
//	public BookInfo resetLoginFailureInfo() {
//		return new BookInfo(bookId, bookName, holder,bookStatusKind, category,
//				rentedTime, createTime, updateTime, updateUser);
//	}
//
//	/**
//	 * ログイン失敗回数、アカウントロック日時を更新し、アカウントロック状態に更新します。
//	 * 
//	 * @return ログイン失敗回数、アカウントロック日時が更新された、自身のインスタンス
//	 */
//	public BookInfo updateAccountLocked() {
//		return new BookInfo(bookId, bookName, holder, bookStatusKind, category,
//				rentedTime, createTime, updateTime, updateUser);
//	}

}
