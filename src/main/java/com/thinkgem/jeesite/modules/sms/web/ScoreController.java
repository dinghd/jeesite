package com.thinkgem.jeesite.modules.sms.web;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sms.entity.Course;
import com.thinkgem.jeesite.modules.sms.entity.Score;
import com.thinkgem.jeesite.modules.sms.entity.Student;
import com.thinkgem.jeesite.modules.sms.service.CourseService;
import com.thinkgem.jeesite.modules.sms.service.ScoreService;
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
import java.util.List;

/**
 * 学生Controller
 * @author Gaowang
 * @version 2017-08-02
 */

@Controller
@RequestMapping(value = "${adminPath}/sms/score")
public class ScoreController extends BaseController {

    @Autowired
    private ScoreService scoreService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @ModelAttribute
    public Score get(@RequestParam(required=false) String id) {
        if (StringUtils.isNotBlank(id)){
            return scoreService.get(id);
        }else{
            return new Score();
        }
    }

    @RequestMapping(value = {"list", ""})
    public String list(Score score, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Score> page = scoreService.findPage(new Page<Score>(request, response), score);
        model.addAttribute("page", page);
        return "modules/sms/scoreList";
    }

    @RequestMapping(value = "form")
    public String form(Score score, Model model) {
        model.addAttribute("students",studentService.findList(new Student()));
        model.addAttribute("courses",courseService.findList(new Course()));
        model.addAttribute("score", score);
        return "modules/sms/scoreForm";
    }

    @RequestMapping(value = "save")
    public String save(Score score, Model model, RedirectAttributes redirectAttributes) {
        if(Global.isDemoMode()){
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sms/score/?repage";
        }
        List<Score> scores = scoreService.findList(score);
        if(score.getId() == null && scores.size() > 0){
            addMessage(redirectAttributes, score.getStudent().getName() + "的"
                    + score.getCourse().getName() + "成绩已经录入！成绩为: "
                    + scores.get(0).getScore() + "分！");
            return "redirect:" + adminPath + "/sms/score/?repage";
        }
        if (!beanValidator(model, score)){
            return form(score, model);
        }
        scoreService.save(score);
        addMessage(redirectAttributes, "保存课程信息'" + score.getScore() + "'成功");
        return "redirect:" + adminPath + "/sms/score/?repage";
    }

    @RequestMapping(value = "delete")
    public String delete(Score score, @RequestParam(required=false) Boolean isRe, RedirectAttributes redirectAttributes) {
        if(Global.isDemoMode()){
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sms/score/?repage";
        }
        scoreService.delete(score, isRe);
        addMessage(redirectAttributes, (isRe!=null&&isRe?"恢复":"")+"删除学生成功");
        return "redirect:" + adminPath + "/sms/score/?repage";
    }

}
