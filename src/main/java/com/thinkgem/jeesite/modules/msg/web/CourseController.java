package com.thinkgem.jeesite.modules.msg.web;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.msg.entity.Course;
import com.thinkgem.jeesite.modules.msg.service.CourseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "${adminPath}/msg/course")
public class CourseController extends BaseController{

    @Autowired
    private CourseService courseService;

    @RequiresPermissions("course:list")
    @RequestMapping(value = {"list",""})
    public String list(Course course, HttpServletRequest request, HttpServletResponse response, Model model){
        Page<Course> page = courseService.findPage(new Page<Course>(request,response), course);
        model.addAttribute("page",page);
        return "modules/msg/course";
    }

    @RequiresPermissions("msg:course:view")
    @RequestMapping(value = "form")
    public String form(Course course, Model model) {
        if (null != course.getId()){
            course = courseService.get(course);
        }
        model.addAttribute("course", course);
        return "modules/msg/courseForm";
    }

    @RequiresPermissions("msg:course:edit")
    @RequestMapping(value = "save")
    public String save(Course course, RedirectAttributes redirectAttributes) {
        courseService.save(course);
        addMessage(redirectAttributes, "保存'" + course.getName() + "'成功");
        return "redirect:" + adminPath + "/msg/course/?repage";
    }

    @RequiresPermissions("msg:course:edit")
    @RequestMapping(value = "delete")
    public String delete(Course course, RedirectAttributes redirectAttributes) {
        courseService.delete(course);
        addMessage(redirectAttributes, "删除课程成功");
        return "redirect:" + adminPath + "/msg/course/?repage";
    }
}
