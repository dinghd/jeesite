package com.thinkgem.jeesite.modules.sms.web;

import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sms.entity.Book;
import com.thinkgem.jeesite.modules.sms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 书籍Controller
 * @author Gaowang
 * @version 2017-08-02
 */

@Controller
@RequestMapping(value = "${adminPath}/sms/book")
public class BookController extends BaseController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = {"list", ""})
    public String list(Book book, HttpServletRequest request, HttpServletResponse response, Model model) {
        List<Book> bookList = bookService.findList(book);
        model.addAttribute("books", bookList);
        return "modules/sms/bookList";
    }

}
