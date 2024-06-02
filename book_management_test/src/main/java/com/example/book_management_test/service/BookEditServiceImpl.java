package com.example.book_management_test.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.book_management_test.constant.BookEditMessage;
import com.example.book_management_test.dto.BookEditResult;
import com.example.book_management_test.dto.BookUpdateInfo;
import com.example.book_management_test.entity.BookInfo;
import com.example.book_management_test.repository.BookInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * 書籍編集画面Service実装クラス
 * 
 * @author ys-fj
 *
 */
@Service
@RequiredArgsConstructor
public class BookEditServiceImpl implements BookEditService {

	/** 書籍情報テーブルRepository */
	private final BookInfoRepository repository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<BookInfo> searchBookInfo(String bookId) {
		return repository.findById(bookId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BookEditResult updateBookInfo(BookUpdateInfo bookUpdateInfo) {
		var bookUpdateResult = new BookEditResult();

		// 現在の登録情報を取得
		var updateInfoOpt = repository.findById(bookUpdateInfo.getBookId());
		if (updateInfoOpt.isEmpty()) {
			bookUpdateResult.setUpdateMessage(BookEditMessage.FAILED);
			return bookUpdateResult;
		}

		// 画面の入力情報等をセット
		var updateInfo = updateInfoOpt.get();
		updateInfo.setBookStatusKind(bookUpdateInfo.getBookStatusKind());

		updateInfo.setUpdateTime(LocalDateTime.now());
		updateInfo.setUpdateUser(bookUpdateInfo.getUpdateBookId());
//		updateInfo.setUpdateUser(bookUpdateInfo.getUpdateUser());

		try {
			repository.save(updateInfo);
		} catch (Exception e) {
			bookUpdateResult.setUpdateMessage(BookEditMessage.FAILED);
			return bookUpdateResult;
		}

		bookUpdateResult.setUpdateBookInfo(updateInfo);
		bookUpdateResult.setUpdateMessage(BookEditMessage.SUCCEED);
		return bookUpdateResult;
	}

}
