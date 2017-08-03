package com.thinkgem.jeesite.modules.sms.service;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sms.dao.StudentDao;
import com.thinkgem.jeesite.modules.sms.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 学生Service
 * @author Gaowang
 * @version 2017-08-02
 */

@Service
@Transactional(readOnly = true)
public class StudentService extends CrudService<StudentDao, Student>{

    @Transactional(readOnly = false)
    public void delete(Student student, Boolean isRe) {
        student.setDelFlag(isRe!=null&&isRe?Student.DEL_FLAG_NORMAL:Student.DEL_FLAG_DELETE);
        super.delete(student);
    }

}
