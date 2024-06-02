package com.example.book_management_dev.service;

import java.util.Optional;

import com.example.book_management_dev.dto.UserEditResult;
import com.example.book_management_dev.dto.UserUpdateInfo;
import com.example.book_management_dev.entity.UserInfo;

/**
 * ユーザー編集画面Serviceインターフェース
 * 
 * @author ys-fj
 *
 */
public interface UserEditService {

	/**
	 * ログインIDを使ってユーザー情報テーブルを検索し、検索結果を返却します。
	 * 
	 * @param loginId ログインID
	 * @return 該当のユーザー情報テーブル登録情報
	 */
	public Optional<UserInfo> searchUserInfo(String loginId);

	/**
	 * ユーザー情報テーブルを更新します。
	 * 
	 * @param userUpdateInfo ユーザー更新情報
	 * @return 更新結果
	 */
	public UserEditResult updateUserInfo(UserUpdateInfo userUpdateInfo);

}
