package cn.hyj.controller;

import cn.hyj.entity.User;
import cn.hyj.exception.MailException;
import cn.hyj.service.UserService;
import cn.hyj.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequestMapping("/user/")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping("login")
    public String login(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password){

        User user = userService.userLoginVerify(username,password);

        if (username.equals(user.getUsername()) && password.equals(user.getPassword())){
            request.getSession().setAttribute("user",user);
            return "index";
        }
        return "login";
    }

    @Autowired
    private MailUtils mailUtils;

    /**
     * 获取验证码
     *
     * @param user 用户
     * @return
     */
    @RequestMapping("/registerCode")
    public String register(User user, Model model) throws MailException {
        Integer activationCode = (int) ((Math.random() * 9 + 1) * 1000);//激活码
        Date date = new Date();//获取当前时间
        user.setRegister(date);
        user.setStatus(1);
        try {
            mailUtils.sendActiveMail(user.getEmail(), activationCode.toString(), "registered");//发送邮件
        } catch (Exception e) {
            e.printStackTrace();
            throw new MailException("发送邮箱失败!");
        }
        model.addAttribute("user", user);//将用户对象放入session作用域中
        model.addAttribute("code", activationCode);//把验证码放入session作用域中
        return "forward:/notarizeEmail.jsp";
    }

    /**
     * 注册
     *
     * @param code
     * @return
     */
    @RequestMapping("/register")
    public String register(@RequestParam("code") String code, ModelMap modelMap) {
        Integer _code = (Integer) modelMap.getAttribute("code");//取出session中的验证码
        User user = (User) modelMap.getAttribute("user");//取出session中的user对象
        if (_code.toString().equals(code)) {
            userService.userRegister(user);//保存数据库
        }
        return "login";
    }


}
