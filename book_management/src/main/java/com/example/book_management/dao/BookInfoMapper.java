package com.example.book_management.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.book_management.bean.BookInfo;
import com.example.book_management.dto.BookAddRequest;
import com.example.book_management.dto.BookSearchRequest;

/**
 * 書籍情報 Mapper
 */
@Mapper
public interface BookInfoMapper {

    /**
     * 書籍情報全件検索
     * @param book 検索用リクエストデータ
     * @return 検索結果
     */
    List<BookInfo> findAll();

    /**
     * 書籍情報検索
     * @param book 検索用リクエストデータ
     * @return 検索結果
     */
    List<BookInfo> search(BookSearchRequest bookSearchRequest);

    /**
     * 書籍情報登録
     * @param bookRequest 登録用リクエストデータ
     */
    void save(BookAddRequest bookAddRequest);
    
    /**
     * 書籍情報の論理削除
     * @param bookId ID
     */
    void delete(int bookId);
}