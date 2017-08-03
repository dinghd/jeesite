package com.thinkgem.jeesite.modules.sms.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sms.entity.Book;

/**
 * 图书DAO接口
 * @author Gaowang
 * @version 2017-08-01
 */

@MyBatisDao
public interface BookDao extends CrudDao<Book> {

}
