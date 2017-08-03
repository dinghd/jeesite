package com.thinkgem.jeesite.modules.sms.web;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sms.entity.Course;
import com.thinkgem.jeesite.modules.sms.service.CourseService;
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
 * 课程Controller
 * @author Gaowang
 * @version 2017-08-02
 */

@Controller
@RequestMapping(value = "${adminPath}/sms/course")
public class CourseController extends BaseController {

    @Autowired
    private CourseService courseService;

    @ModelAttribute
    public Course get(@RequestParam(required=false) String id) {
        if (StringUtils.isNotBlank(id)){
            return courseService.get(id);
        }else{
            return new Course();
        }
    }

    @RequestMapping(value = {"list", ""})
    public String list(Course course, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Course> page = courseService.findPage(new Page<Course>(request, response), course);
        model.addAttribute("page", page);
        return "modules/sms/courseList";
    }

    @RequestMapping(value = "form")
    public String form(Course course, Model model) {
        model.addAttribute("course", course);
        return "modules/sms/courseForm";
    }

    @RequestMapping(value = "save")
    public String save(Course course, Model model, RedirectAttributes redirectAttributes) {
        if(Global.isDemoMode()){
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sms/course/?repage";
        }
        if (!beanValidator(model, course)){
            return form(course, model);
        }
        courseService.save(course);
        addMessage(redirectAttributes, "保存课程信息'" + course.getName() + "'成功");
        return "redirect:" + adminPath + "/sms/course/?repage";
    }

    @RequestMapping(value = "delete")
    public String delete(Course course, @RequestParam(required=false) Boolean isRe, RedirectAttributes redirectAttributes) {
        if(Global.isDemoMode()){
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sms/course/?repage";
        }
        courseService.delete(course, isRe);
        addMessage(redirectAttributes, (isRe!=null&&isRe?"恢复":"")+"删除课程成功");
        return "redirect:" + adminPath + "/sms/course/?repage";
    }

}
