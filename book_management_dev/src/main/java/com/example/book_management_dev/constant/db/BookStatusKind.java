package com.example.book_management_dev.constant.db;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 貸出状態種別
 * 
 * @author ys-fj
 */
@Getter
@AllArgsConstructor
public enum BookStatusKind {

	/* 貸出可能 */
	ENABLED(false, ""),

	/* 貸出不可 */
	DISABLED(true, "貸出中");

	/** 貸出不可か */
	private boolean isDisabled;

	/** 画面表示する説明文 */
	private String displayValue;

}
