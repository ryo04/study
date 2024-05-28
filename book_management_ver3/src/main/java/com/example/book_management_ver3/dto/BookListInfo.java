package com.example.book_management_ver3.dto;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * 書籍一覧画面DTOクラス
 * 
 * @author ys-fj
 *
 */
@Data
public class BookListInfo {

	/** 書籍ID */
	private String bookId;
	
	/** 書籍名 */
	private String bookName;
	
	/** カテゴリー */
	private String category;

	/** 貸出状態 */
	private String status;

	/** 登録日時 */
	private LocalDateTime createTime;

	/** 最終更新日時 */
	private LocalDateTime updateTime;

	/** 最終更新ユーザ */
	private String updateUser;

}
