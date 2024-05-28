package com.example.book_management_ver3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.book_management_ver3.constant.BookDeleteResult;
import com.example.book_management_ver3.dto.BookListInfo;
import com.example.book_management_ver3.dto.BookSearchInfo;
import com.example.book_management_ver3.entity.BookInfo;
import com.example.book_management_ver3.repository.BookInfoRepository;
import com.example.book_management_ver3.util.AppUtil;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

/**
 * 書籍一覧画面Service実装クラス
 * 
 * @author ys-fj
 *
 */
@Service
@RequiredArgsConstructor
public class BookListServiceImpl implements BookListService {

	/** 書籍情報テーブルDAO */
	private final BookInfoRepository repository;

	/** Dozer Mapper */
	private final Mapper mapper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BookListInfo> editBookList() {
		return toBookListInfos(repository.findAll());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BookListInfo> editBookListByParam(BookSearchInfo dto) {
		return toBookListInfos(findBookInfoByParam(dto));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BookDeleteResult deleteBookInfoById(String bookId) {
		var bookInfo = repository.findById(bookId);
		if (bookInfo.isEmpty()) {
			return BookDeleteResult.ERROR;
		}

		repository.deleteById(bookId);

		return BookDeleteResult.SUCCEED;
	}

	/**
	 * 書籍情報の条件検索を行い、検索結果を返却します。
	 * 
	 * @param form 入力情報
	 * @return 検索結果
	 */
	private List<BookInfo> findBookInfoByParam(BookSearchInfo dto) {
		var bookIdParam = AppUtil.addWildcard(dto.getBookId());

		if (dto.getBookStatusKind() != null) {
			return repository.findByBookIdLikeAndBookStatusKind(bookIdParam,
					dto.getBookStatusKind());
		} else {
			return repository.findByBookIdLike(bookIdParam);
		}
	}

	/**
	 * 書籍情報EntityのListを書籍一覧情報DTOのListに変換します。
	 * 
	 * @param bookInfos 書籍情報EntityのList
	 * @return 書籍一覧情報DTOのList
	 */
	private List<BookListInfo> toBookListInfos(List<BookInfo> bookInfos) {
		var bookListInfos = new ArrayList<BookListInfo>();
		for (BookInfo bookInfo : bookInfos) {
			var bookListInfo = mapper.map(bookInfo, BookListInfo.class);
			bookListInfo.setStatus(bookInfo.getBookStatusKind().getDisplayValue());
			bookListInfos.add(bookListInfo);
		}

		return bookListInfos;

	}

}
