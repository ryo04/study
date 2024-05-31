package com.example.book_management_ver3.controller;

import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.book_management_ver3.constant.BookEditMessage;
import com.example.book_management_ver3.constant.MessageConst;
import com.example.book_management_ver3.constant.ModelKey;
import com.example.book_management_ver3.constant.SessionKeyConst;
import com.example.book_management_ver3.constant.UrlConst;
import com.example.book_management_ver3.constant.ViewNameConst;
import com.example.book_management_ver3.constant.db.BookStatusKind;
import com.example.book_management_ver3.dto.BookEditInfo;
import com.example.book_management_ver3.dto.BookUpdateInfo;
import com.example.book_management_ver3.form.BookEditForm;
import com.example.book_management_ver3.service.BookEditService;
import com.example.book_management_ver3.util.AppUtil;
import com.github.dozermapper.core.Mapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

/**
 * 書籍編集画面Controllerクラス
 * 
 * @author ys-fj
 *
 */
@Controller
@RequiredArgsConstructor
public class BookEditController {

	/** 書籍編集画面Serviceクラス */
	private final BookEditService service;

	/** セッションオブジェクト */
	private final HttpSession session;

	/** Dozer Mapper */
	private final Mapper mapper;

	/** メッセージソース */
	private final MessageSource messageSource;

	/** リダイレクトパラメータ：エラー有 */
	private static final String REDIRECT_PRAM_ERR = "err";

	/**
	 * 前画面で選択された書籍IDに紐づく書籍情報を画面に表示します。
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 書籍編集画面テンプレート名
	 * @throws Exception 
	 */
	@GetMapping(UrlConst.BOOK_EDIT)
	public String view(Model model, BookEditForm form) throws Exception {
		var bookId = (String) session.getAttribute(SessionKeyConst.SELECETED_BOOK_ID);
		var bookInfoOpt = service.searchBookInfo(bookId);
		if (bookInfoOpt.isEmpty()) {
			model.addAttribute(ModelKey.MESSAGE,
					AppUtil.getMessage(messageSource, MessageConst.BOOKEDIT_NON_EXISTED_LOGIN_ID));
			return ViewNameConst.EDIT_ERROR;
		}
		var bookInfo = bookInfoOpt.get();
		model.addAttribute("bookEditForm", mapper.map(bookInfo, BookEditForm.class));
		model.addAttribute("bookEditInfo", mapper.map(bookInfo, BookEditInfo.class));
		model.addAttribute("bookStatusKindOptions", BookStatusKind.values());

		return ViewNameConst.BOOK_EDIT;
	}

	/**
	 * 画面の更新エラー時にエラーメッセージを表示します。
	 * 
	 * @param model モデル
	 * @return 書籍編集エラー画面テンプレート名
	 */
	@GetMapping(value = UrlConst.BOOK_EDIT, params = REDIRECT_PRAM_ERR)
	public String viewWithError(Model model) {
		return ViewNameConst.EDIT_ERROR;
	}

	/**
	 * 画面の入力情報をもとに書籍情報を更新します。
	 * 
	 * @param form 入力情報
	 * @param user 認証済みユーザー情報
	 * @param redirectAttributes リダイレクト用オブジェクト
	 * @return リダイレクトURL
	 */
	@PostMapping(value = UrlConst.BOOK_EDIT, params = "update")
	public String updateUser(BookEditForm form, @AuthenticationPrincipal User user,
			RedirectAttributes redirectAttributes) {
		var updateDto = mapper.map(form, BookUpdateInfo.class);
		updateDto.setBookId((String) session.getAttribute(SessionKeyConst.SELECETED_BOOK_ID));
//		updateDto.setUpdateUser(updateDto.getUpdateUser());
		updateDto.setUpdateBookId(user.getUsername());

		var updateResult = service.updateBookInfo(updateDto);
		var updateMessage = updateResult.getUpdateMessage();
		if (updateMessage == BookEditMessage.FAILED) {
			redirectAttributes.addFlashAttribute(ModelKey.MESSAGE,
					AppUtil.getMessage(messageSource, updateMessage.getMessageId()));
			redirectAttributes.addAttribute(REDIRECT_PRAM_ERR, "");
			return AppUtil.doRedirect(UrlConst.BOOK_EDIT);
		}

		redirectAttributes.addFlashAttribute(ModelKey.IS_ERROR, false);
		redirectAttributes.addFlashAttribute(ModelKey.MESSAGE,
				AppUtil.getMessage(messageSource, updateMessage.getMessageId()));

		return AppUtil.doRedirect(UrlConst.BOOK_EDIT);
	}

}
