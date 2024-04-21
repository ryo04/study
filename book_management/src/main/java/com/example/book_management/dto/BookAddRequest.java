package com.example.book_management.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 書籍情報登録 リクエストデータ
 */
@Data
public class BookAddRequest implements Serializable {
    /**
     * 書籍名
     */
    @NotEmpty(message = "書籍名を入力してください")
    @Size(max = 50, message = "名前は50桁以内で入力してください")
    private String bookName;
    /**
     * 保持者
     */
    @Size(max = 50, message = "保持者は50桁以内で入力してください")
    private String holder;
    /**
     * カテゴリー
     */
    @Size(max = 20, message = "カテゴリーは20桁以内で入力してください")
    private String category;
}