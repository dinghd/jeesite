package com.thinkgem.jeesite.modules.msg.service;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.msg.dao.CourseDao;
import com.thinkgem.jeesite.modules.msg.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CourseService extends CrudService<CourseDao, Course>{

    @Autowired
    private CourseDao courseDao;


}
