package com.thinkgem.jeesite.modules.sms.web;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sms.entity.Student;
import com.thinkgem.jeesite.modules.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 学生Controller
 * @author Gaowang
 * @version 2017-08-02
 */

@Controller
@RequestMapping(value = "${adminPath}/sms/student")
public class StudentController extends BaseController {

    @Autowired
    private StudentService studentService;

    @ModelAttribute
    public Student get(@RequestParam(required=false) String id) {
        if (StringUtils.isNotBlank(id)){
            return studentService.get(id);
        }else{
            return new Student();
        }
    }

    @RequestMapping(value = {"list", ""})
    public String list(Student student, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Student> page = studentService.findPage(new Page<Student>(request, response), student);
        model.addAttribute("page", page);
        return "modules/sms/studentList";
    }

    @RequestMapping(value = "form")
    public String form(Student student, Model model) {
        model.addAttribute("student", student);
        return "modules/sms/studentForm";
    }

    @RequestMapping(value = "save")
    public String save(Student student, Model model, RedirectAttributes redirectAttributes) {
        if(Global.isDemoMode()){
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sms/student/?repage";
        }
        if (!beanValidator(model, student)){
            return form(student, model);
        }
        studentService.save(student);
        addMessage(redirectAttributes, "保存学生信息'" + student.getName() + "'成功");
        return "redirect:" + adminPath + "/sms/student/?repage";
    }

    @RequestMapping(value = "delete")
    public String delete(Student student, @RequestParam(required=false) Boolean isRe, RedirectAttributes redirectAttributes) {
        if(Global.isDemoMode()){
        addMessage(redirectAttributes, "演示模式，不允许操作！");
        return "redirect:" + adminPath + "/sms/student/?repage";
    }
        studentService.delete(student, isRe);
    addMessage(redirectAttributes, (isRe!=null&&isRe?"恢复":"")+"删除学生成功");
        return "redirect:" + adminPath + "/sms/student/?repage";
}

}
