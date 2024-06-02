package com.example.book_management_dev.controller;

import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.book_management_dev.constant.BookDeleteResult;
import com.example.book_management_dev.constant.ModelKey;
import com.example.book_management_dev.constant.SessionKeyConst;
import com.example.book_management_dev.constant.UrlConst;
import com.example.book_management_dev.constant.ViewNameConst;
import com.example.book_management_dev.constant.db.BookStatusKind;
import com.example.book_management_dev.dto.BookListInfo;
import com.example.book_management_dev.dto.BookSearchInfo;
import com.example.book_management_dev.form.BookListForm;
import com.example.book_management_dev.service.BookListService;
import com.example.book_management_dev.util.AppUtil;
import com.github.dozermapper.core.Mapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

/**
 * 書籍一覧画面Controllerクラス
 * 
 * @author ys-fj
 *
 */
@Controller
@RequiredArgsConstructor
public class BookListController {

	/** 書籍一覧画面Serviceクラス */
	private final BookListService service;

	/** Dozer Mapper */
	private final Mapper mapper;

	/** メッセージソース */
	private final MessageSource messageSource;

	/** セッションオブジェクト */
	private final HttpSession session;

	/** モデルキー：書籍情報リストフォーム */
	private static final String KEY_BOOKLIST_FORM = "bookListForm";

	/** モデルキー：書籍情報リスト */
	private static final String KEY_BOOKLIST = "bookList";

	/** モデルキー：書籍情報リスト */
	private static final String KEY_BOOK_STATUS_KIND_OPTIONS = "bookStatusKindOptions";

	/** モデルキー：操作種別 */
	private static final String KEY_OPERATION_KIND = "operationKind";

	/**
	 * 画面の初期表示を行います。
	 * 
	 * <p>またその際、画面選択項目「貸出状態」の選択肢を生成して画面に渡します。
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 書籍一覧画面テンプレート名
	 */
	@GetMapping(UrlConst.BOOK_LIST)
	public String view(Model model, BookListForm form) {
		session.removeAttribute(SessionKeyConst.SELECETED_BOOK_ID);

		model.addAttribute(KEY_BOOKLIST, editBookListInfo(model));
		model.addAttribute(KEY_BOOK_STATUS_KIND_OPTIONS, BookStatusKind.values());

		return ViewNameConst.BOOK_LIST;
	}

	/**
	 * 初期表示、検索後や削除後のリダイレクトによる再表示のいずれかかを判定して画面に表示する一覧情報を作成します。
	 * 
	 * @param model モデル
	 * @return 書籍一覧情報
	 */
	@SuppressWarnings("unchecked")
	private List<BookListInfo> editBookListInfo(Model model) {
		var doneSearchOrDelete = model.containsAttribute(KEY_OPERATION_KIND);
		if (doneSearchOrDelete) {
			var operationKind = (OperationKind) model.getAttribute(KEY_OPERATION_KIND);
			if (operationKind == OperationKind.SEARCH) {
				return (List<BookListInfo>) model.getAttribute(KEY_BOOKLIST);
			}
			if (operationKind == OperationKind.DELETE) {
				var searchDto = mapper.map((BookListForm) model.getAttribute(KEY_BOOKLIST_FORM), BookSearchInfo.class);
				return service.editBookListByParam(searchDto);
			}
		}

		return service.editBookList();
	}

	/**
	 * 検索条件に合致する書籍情報を画面に表示します。
	 * 
	 * @param form 入力情報
	 * @param redirectAttributes リダイレクト用オブジェクト
	 * @return リダイレクトURL
	 */
	@PostMapping(value = UrlConst.BOOK_LIST, params = "search")
	public String searchBook(BookListForm form, RedirectAttributes redirectAttributes) {
		var searchDto = mapper.map(form, BookSearchInfo.class);
		var bookInfos = service.editBookListByParam(searchDto);
		redirectAttributes.addFlashAttribute(KEY_BOOKLIST, bookInfos);
		redirectAttributes.addFlashAttribute(KEY_BOOKLIST_FORM, form);
		redirectAttributes.addFlashAttribute(KEY_OPERATION_KIND, OperationKind.SEARCH);

		return AppUtil.doRedirect(UrlConst.BOOK_LIST);
	}

	/**
	 * 選択行の書籍情報を削除して、最新情報で画面を再表示します。
	 * 
	 * @param form 入力情報
	 * @return リダイレクトURL
	 */
	@PostMapping(value = UrlConst.BOOK_LIST, params = "edit")
	public String updateBook(BookListForm form) {
		session.setAttribute(SessionKeyConst.SELECETED_BOOK_ID, form.getSelectedBookId());
		return AppUtil.doRedirect(UrlConst.BOOK_EDIT);
	}

	/**
	 * 選択行の書籍情報を削除して、最新情報で画面を再表示します。
	 * 
	 * @param form 入力情報
	 * @param redirectAttributes リダイレクト用オブジェクト
	 * @return リダイレクトURL
	 */
	@PostMapping(value = UrlConst.BOOK_LIST, params = "delete")
	public String deleteBook(BookListForm form, RedirectAttributes redirectAttributes) {
		var executeResult = service.deleteBookInfoById(form.getSelectedBookId());
		redirectAttributes.addFlashAttribute(ModelKey.IS_ERROR, executeResult == BookDeleteResult.ERROR);
		redirectAttributes.addFlashAttribute(ModelKey.MESSAGE,
				AppUtil.getMessage(messageSource, executeResult.getMessageId()));
		// 削除後、フォーム情報の「選択された書籍ID」は不要になるため、クリアします。
		redirectAttributes.addFlashAttribute(KEY_BOOKLIST_FORM, form.clearSelectedBookId());
		redirectAttributes.addFlashAttribute(KEY_OPERATION_KIND, OperationKind.DELETE);

		return AppUtil.doRedirect(UrlConst.BOOK_LIST);
	}

	/**
	 * 操作種別Enum
	 * 
	 * @author ys-fj
	 */
	public enum OperationKind {
		SEARCH, DELETE
	}
}
