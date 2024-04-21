package com.example.book_management.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.book_management.bean.BookInfo;
import com.example.book_management.dto.BookAddRequest;
import com.example.book_management.dto.BookSearchRequest;
import com.example.book_management.service.BookInfoService;

/**
 * 書籍情報 Controller
 */
@Controller
public class BookInfoController {

    /**
     * 書籍情報 Service
     */
    @Autowired
    private BookInfoService bookInfoService;

    /**
     * 書籍情報一覧画面を表示
     * @param model Model
     * @return 書籍情報一覧画面
     */
    @GetMapping(value = "/book/list")
    public String displayList(Model model) {
        List<BookInfo> userList = bookInfoService.findAll();
        model.addAttribute("booklist", userList);
        model.addAttribute("bookSearchRequest", new BookSearchRequest());
        return "book/search";
    }
    
    /**
     * 新規書籍登録画面を表示
     * @param model Model
     * @return 書籍情報一覧画面
     */
    @GetMapping(value = "/book/add")
    public String displayAdd(Model model) {
        model.addAttribute("bookAddRequest", new BookAddRequest());
        return "book/add";
    }

//    /**
//     * 書籍新規登録画面を表示
//     * @param model Model
//     * @return ユーザー情報一覧画面
//     */
//    @GetMapping(value = "/user/add")
//    public String displayAdd(Model model) {
//        model.addAttribute("userAddRequest", new UserAddRequest());
//        return "user/add";
//    }
    
    /**
     * 書籍情報削除（論理削除）
     * @param bookId ID
     * @param model Model
     * @return 書籍情報一覧画面
     */
    @GetMapping("/book/delete")
    public String delete(@PathVariable int bookId, Model model) {
        // 書籍情報の削除
        bookInfoService.delete(bookId);
        return "redirect:/book/list";
    }

    /**
     * 書籍情報検索
     * @param bookSearchRequest リクエストデータ
     * @param model Model
     * @return 書籍情報一覧画面
     */
    @PostMapping("/book/search")
    public String search(@ModelAttribute BookSearchRequest bookSearchRequest, Model model) {
        List<BookInfo> bookList = bookInfoService.search(bookSearchRequest);
        model.addAttribute("booklist", bookList);
        return "book/search";
    }
    
    /**
     * 新規書籍登録
     * @param bookRequest リクエストデータ
     * @param model Model
     * @return 書籍情報一覧画面
     */
    @PostMapping("/book/create")
    public String create(@Validated @ModelAttribute BookAddRequest bookRequest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // 入力チェックエラーの場合
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            return "book/add";
        }
        // 書籍情報の登録
        bookInfoService.save(bookRequest);
        return "redirect:/book/list";
    }

//    /**
//     * ユーザー新規登録
//     * @param userRequest リクエストデータ
//     * @param model Model
//     * @return ユーザー情報一覧画面
//     */
//    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
//    public String create(@Validated @ModelAttribute UserAddRequest userRequest, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            // 入力チェックエラーの場合
//            List<String> errorList = new ArrayList<String>();
//            for (ObjectError error : result.getAllErrors()) {
//                errorList.add(error.getDefaultMessage());
//            }
//            model.addAttribute("validationError", errorList);
//            return "user/add";
//        }
//        // ユーザー情報の登録
//        userInfoService.save(userRequest);
//        return "redirect:/user/list";
//    }
}