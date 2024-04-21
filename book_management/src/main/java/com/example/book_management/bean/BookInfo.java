package com.example.book_management.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 書籍情報 Bean
 */
// ＠dataは使わずにgetterとsetterを使って明示的にする。
@Data
public class BookInfo implements Serializable {

    /**
     * ID
     */
    private int bookId;

    /**
     * 書籍名
     */
    private String bookName;

    /**
     * 保持者
     */
    private String holder;

    /**
     * 貸出ステータス
     */
    private int lendingFlg;

    /**
     * 更新日時
     */
    private Date updateDate;

    /**
     * 貸出日時
     */
    private Date rentedDate;

    /**
     * カテゴリー
     */
    private String category;

}