package com.thinkgem.jeesite.modules.sms.service;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sms.dao.BookDao;
import com.thinkgem.jeesite.modules.sms.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 图书Service
 * @author Gaowang
 * @version 2017-08-01
 */

/**
 * 书籍Service
 * @author Gaowang
 * @version 2017-08-02
 */

@Service
@Transactional(readOnly = true)
public class BookService extends CrudService<BookDao, Book> {

}
