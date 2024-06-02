package com.example.book_management_dev.constant;

/**
 * エラーメッセージID定数クラス
 * 
 * @author ys-fj
 *
 */
public class MessageConst {

	/** 共通：入力内容誤り */
	public static final String FORM_ERROR = "common.formError";

	/** ユーザー登録画面：既に本登録済み */
	public static final String SIGNUP_ALREADY_COMPLETED = "signup.alreadyCompleted";

	/** ユーザー登録画面：DB更新時エラー */
	public static final String SIGNUP_DB_ERROR = "signup.dbError";
	
	/** ユーザー登録画面：ユーザー登録完了 */
	public static final String SIGNUP_TENTATIVE_SUCCEED = "signup.tentativeSucceed";
	
	/** ユーザー登録画面：性別の未入力 */
	public static final String SIGNUP_SEX_EMPTY = "signup.sexEmpty";
	
	/** ユーザー登録画面：名前の未入力 */
	public static final String SIGNUP_NAME_EMPTY = "signup.nameEmpty";
	
	/** ユーザー登録画面：フリガナの未入力 */
	public static final String SIGNUP_FURIGANA_EMPTY = "signup.furiganaEmpty";

	/** ユーザー登録情報確認画面：既に本登録済み */
	public static final String SIGNUP_CONFIRM_ALREADY_COMPLETED = "signupConfirm.alreadyCompleted";

	/** ユーザー一覧画面：存在しないログインID */
	public static final String USERLIST_NON_EXISTED_LOGIN_ID = "userList.nonExistedLoginId";

	/** ユーザー一覧画面：ユーザー削除完了 */
	public static final String USERLIST_DELETE_SUCCEED = "userList.deleteSucceed";

	/** ユーザー情報編集画面：存在しないログインID */
	public static final String USEREDIT_NON_EXISTED_LOGIN_ID = "userEdit.nonExistedLoginId";

	/** ユーザー情報編集画面：ユーザー更新失敗 */
	public static final String USEREDIT_UPDATE_FAILED = "userEdit.updateFailed";

	/** ユーザー情報編集画面：ユーザー更新完了 */
	public static final String USEREDIT_UPDATE_SUCCEED = "userEdit.updateSucceed";
	
	/** これより下は追加したもの */
	
	/** 書籍一覧画面：存在しない書籍ID */
	public static final String BOOKLIST_NON_EXISTED_LOGIN_ID = "bookList.nonExistedLoginId";
	
	/** 書籍一覧画面：書籍削除完了 */
	public static final String BOOKLIST_DELETE_SUCCEED = "bookList.deleteSucceed";
	
	/** 書籍情報編集画面：存在しない書籍ID */
	public static final String BOOKEDIT_NON_EXISTED_LOGIN_ID = "bookEdit.nonExistedLoginId";
	
	/** 書籍情報編集画面：書籍更新失敗 */
	public static final String BOOKEDIT_UPDATE_FAILED = "bookEdit.updateFailed";

	/** 書籍情報編集画面：書籍更新完了 */
	public static final String BOOKEDIT_UPDATE_SUCCEED = "bookEdit.updateSucceed";
	
}
