package com.thinkgem.jeesite.modules.sms.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sms.entity.Course;
import com.thinkgem.jeesite.modules.sms.entity.Student;

/**
 * 课程Dao
 * @author Gaowang
 * @version 2017-08-02
 */

@MyBatisDao
public interface CourseDao extends CrudDao<Course> {

    public Course getByName(String name);

}
