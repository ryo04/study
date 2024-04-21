package com.example.book_management.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * 書籍情報 検索用リクエストデータ
 */
@Data
public class BookSearchRequest implements Serializable {

    /**
     * 書籍名
     */
    private String bookName;

    /**
     * 保持者
     */
    private String holder;

    /**
     * カテゴリー
     */
    private String category;
}