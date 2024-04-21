package com.example.book_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book_management.bean.BookInfo;
import com.example.book_management.dao.BookInfoMapper;
import com.example.book_management.dto.BookAddRequest;
import com.example.book_management.dto.BookSearchRequest;

/**
 * 書籍情報 Service
 */
@Service
public class BookInfoService {

    /**
     * 書籍情報 Mapper
     */
    @Autowired
    private BookInfoMapper bookInfoMapper;

    /**
     * 書籍情報全件検索
     * @return 検索結果
     */
    public List<BookInfo> findAll() {
        return bookInfoMapper.findAll();
    }

    /**
     * 書籍情報検索
     * @param bookSearchRequest リクエストデータ
     * @return 検索結果
     */
    public List<BookInfo> search(BookSearchRequest bookSearchRequest) {
        return bookInfoMapper.search(bookSearchRequest);
    }

    /**
     * 書籍情報登録
     * @param bookAddRequest リクエストデータ
     */
    public void save(BookAddRequest bookAddRequest) {
        bookInfoMapper.save(bookAddRequest);
    }
    
    /**
     * 書籍情報論理削除
     * @param bookId
     */
    public void delete(int bookId) {
        bookInfoMapper.delete(bookId);
    }
}