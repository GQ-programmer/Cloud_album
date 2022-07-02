package pub.zgq.CloudAlbum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pub.zgq.CloudAlbum.pojo.ResultInfo;
import pub.zgq.CloudAlbum.pojo.User;
import pub.zgq.CloudAlbum.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    //@Autowired User user;
    @Resource
    private ResultInfo info;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 登录方法
     * @param user
     * @param session
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public ResultInfo login(User user, HttpSession session){
        /*user.setUsername(username);
        user.setPassword(password);*/
        //System.out.println(user);
        User user1 = userService.findUser(user);
        //System.out.println(user1+"user1-------");
        //登陆失败
        if (user1 == null){
            info.setFlag(false);
            info.setErrorMsg("账号或密码错误！");
        }else{
            info.setFlag(true);
            info.setUser(user1);
            session.setAttribute("user",user1);
        }
        return info;
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    /**
     * 注册方法
     * @param user
     * @param checkCode
     * @param session
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo register(User user, String checkCode, HttpSession session){
        /*System.out.println(user);
        System.out.println(checkCode);*/
        //获取session中的checkCode
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        //从session中移出,保证验证码不复用
        session.removeAttribute("CHECKCODE_SERVER");
        //判断验证码是否一致
        if (checkcode_server == null || !checkcode_server.equalsIgnoreCase(checkCode)) {
            //验证码错误
            //返回提示结果
            info.setFlag(false);
            info.setErrorMsg("验证码错误!");
        }else {
            //验证码正确
            ResultInfo resultInfo = userService.regist(user);
            info.setFlag(resultInfo.isFlag());
            info.setErrorMsg(resultInfo.getErrorMsg());
        }
        System.out.println(info);
        return info;
    }

    /**
     * 查询用户是否存在方法
     * @param session
     * @return
     */
    @RequestMapping(value = "/selectUser",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo selectUser(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user == null){
            info.setFlag(false);
        }else{
            info.setFlag(true);
        }
        info.setUser(user);
        return info;
    }
    @RequestMapping("/exitUser")
    public String exitUser(HttpSession session){
        session.removeAttribute("user");
        return "redirect:index";
    }
}
