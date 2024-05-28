package com.example.book_management_ver3.entity.converter;

import com.example.book_management_ver3.constant.db.BookStatusKind;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * 書籍情報 貸出状態種別フィールドConverterクラス
 * 
 * @author ys-fj
 *
 */
@Converter
public class BookStatusConverter implements AttributeConverter<BookStatusKind, Boolean> {

	/**
	 * 引数で受け取った貸出状態種別Enumを、利用可否のbooleanに変換します。
	 * 
	 * @param 貸出状態種別Enum
	 * @return 引数で受け取った貸出状態種別Enumに保管されているboolean
	 */
	@Override
	public Boolean convertToDatabaseColumn(BookStatusKind bookStatus) {
		return bookStatus.isDisabled();
	}

	/**
	 * 引数で受け取った権限種別のコード値を、貸出状態種別Enumに変換します。
	 * 
	 * @param 利用可否(利用不可ならtrue)
	 * @return 引数で受け取った利用可否から逆引きした貸出状態種別Enum
	 */
	@Override
	public BookStatusKind convertToEntityAttribute(Boolean isDisabled) {
		return isDisabled ? BookStatusKind.DISABLED : BookStatusKind.ENABLED;
	}
}
