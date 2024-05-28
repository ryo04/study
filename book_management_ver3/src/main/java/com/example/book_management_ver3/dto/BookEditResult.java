package com.example.book_management_ver3.dto;

import com.example.book_management_ver3.constant.BookEditMessage;
import com.example.book_management_ver3.entity.BookInfo;

import lombok.Data;

/**
 * 書籍編集結果DTOクラス
 * 
 * @author ys-fj
 *
 */
@Data
public class BookEditResult {

	/** 書籍更新結果 */
	private BookInfo updateBookInfo;

	/** 書籍更新結果メッセージEnum */
	private BookEditMessage updateMessage;
}
