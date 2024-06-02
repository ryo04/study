package com.example.book_management_dev.constant;

/**
 * URL定数クラス
 * 
 * @author ys-fj
 *
 */
public class UrlConst {

	/** ログイン画面 */
	public static final String LOGIN = "/login";

	/** ユーザー登録画面 */
	public static final String SIGNUP = "/signup";

	/** ユーザー登録情報確認結果画面 */
	public static final String SIGNUP_COMPLETION = "/signupCompletion";

	/** メニュー画面 */
	public static final String MENU = "/menu";

	/** ユーザー一覧画面 */
	public static final String USER_LIST = "/userList";

	/** ユーザー編集画面 */
	public static final String USER_EDIT = "/userEdit";
	
	/** 書籍一覧画面 */
	public static final String BOOK_LIST = "/bookList";

	/** 書籍編集画面 */
	public static final String BOOK_EDIT = "/bookEdit";

	/** 認証不要画面 */
	public static final String[] NO_AUTHENTICATION = { LOGIN, SIGNUP, SIGNUP_COMPLETION, "/webjars/**", "/css/**" };
}
