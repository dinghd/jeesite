package com.thinkgem.jeesite.modules.msg.service;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.msg.dao.StudentDao;
import com.thinkgem.jeesite.modules.msg.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class StudentService extends CrudService<StudentDao, Student> {

    @Autowired
    private StudentDao studentDao;
/*

    @Override
    public Student get(String id) {
        Student entity = dao.get(id);
        return entity;
    }

    public Page<Student> find(Page<Student> page, Student student){
        student.setPage(page);
        page.setList(dao.findList(student));
        return page;
    }

    @Transactional(readOnly = false)
    public void save(Student student) {
        super.save(student);
    }
*/

}
