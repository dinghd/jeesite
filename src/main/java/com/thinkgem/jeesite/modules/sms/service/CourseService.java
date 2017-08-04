package com.thinkgem.jeesite.modules.sms.service;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sms.dao.CourseDao;
import com.thinkgem.jeesite.modules.sms.entity.Course;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 课程Service
 * @author Gaowang
 * @version 2017-08-02
 */

@Service
@Transactional(readOnly = true)
public class CourseService extends CrudService<CourseDao, Course>{

    @Transactional(readOnly = false)
    public void delete(Course course, Boolean isRe) {
        course.setDelFlag(isRe!=null&&isRe?Course.DEL_FLAG_NORMAL:Course.DEL_FLAG_DELETE);
        super.delete(course);
    }

    @Transactional(readOnly = false)
    public Course getByName(String name) {
        return dao.getByName(name);
    }

}
