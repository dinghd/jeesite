package com.thinkgem.jeesite.modules.msg.web;


import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.msg.entity.Student;
import com.thinkgem.jeesite.modules.msg.service.StudentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "${adminPath}/msg/student")
public class StudentController extends BaseController{
    @Autowired
    private StudentService studentService;

    @RequiresPermissions("student:list")
    @RequestMapping(value = {"list",""})
    public String list(Student student, HttpServletRequest request, HttpServletResponse response, Model model){
        Page<Student> page = studentService.findPage(new Page<Student>(request,response), student);
        model.addAttribute("page",page);
        return "modules/msg/student";
    }

    @RequiresPermissions("msg:student:view")
    @RequestMapping(value = "form")
    public String form(Student student, Model model) {
        if (null != student.getId()){
            student = studentService.get(student);
        }
        model.addAttribute("student", student);
        return "modules/msg/studentForm";
    }

    @RequiresPermissions("msg:student:edit")
    @RequestMapping(value = "save")
    public String save(Student student, RedirectAttributes redirectAttributes) {
        studentService.save(student);
        addMessage(redirectAttributes, "保存'" + student.getName() + "'成功");
        return "redirect:" + adminPath + "/msg/student/?repage";
    }

    @RequiresPermissions("msg:student:edit")
    @RequestMapping(value = "delete")
    public String delete(Student student, RedirectAttributes redirectAttributes) {
        studentService.delete(student);
        addMessage(redirectAttributes, "删除学生成功");
        return "redirect:" + adminPath + "/msg/student/?repage";
    }

}
