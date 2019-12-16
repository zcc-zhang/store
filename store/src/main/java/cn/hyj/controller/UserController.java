package cn.hyj.controller;

import cn.hyj.entity.User;
import cn.hyj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;

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
            return "forward:/WEB-INF/jsp/index.jsp";
        }
        return "index";
    }


}
