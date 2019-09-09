package bean.control;

import bean.stru.userstru;
import bean.stru.ton;
import datesource.dao.tableserve;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@RestController
public class login {
    private ApplicationContext context1 = new ClassPathXmlApplicationContext("bean.xml");
    //登录接口;需要的参数有username
    @RequestMapping(path = "/Login1",method= RequestMethod.POST)
    public @ResponseBody userstru login1(@RequestBody userstru user, HttpServletResponse response) throws Exception {
        tableserve<userstru> ax = (tableserve<userstru>) context1.getBean("userserve");
        ax.open();
        user = ax.findone(user);
        ax.close();
        Cookie cookie = new Cookie("name",user.getName().trim());
        cookie.setMaxAge(30 * 60);// 设置为30min
        cookie.setPath("/");
        response.addCookie(cookie);
        return user;
    }
    @RequestMapping(path = "/Login",method = RequestMethod.POST)
    public @ResponseBody userstru lo(userstru user, HttpServletResponse response) throws Exception {
        tableserve<userstru> ax = (tableserve<userstru>) context1.getBean("userserve");
        ax.open();
        user = ax.findone(user);
        ax.close();
        Cookie cookie = new Cookie("name",user.getName().trim());
        cookie.setMaxAge(30 * 60);// 设置为30min
        cookie.setPath("/");
        response.addCookie(cookie);
        return user;
    }
    //注册接口；需要参数有username，id
    @RequestMapping(path = "/registe",method = RequestMethod.POST)
    public @ResponseBody ton Registe(@RequestBody userstru user) throws Exception{
        tableserve<userstru> ax = (tableserve<userstru>) context1.getBean("userserve");
        userstru userstru = new userstru();
        ton a = new ton();
        ax.open();
        userstru = user;
        user = ax.findone(user);
        ax.close();
        if (userstru.getId().equals("null")){
            ax.open();
            ax.save(userstru);
            ax.close();
            a.setStat(1);
            a.setMessage("查询成功");
        }
        else {
            a.setStat(0);
            a.setMessage("查询失败");
        }
        return a;
    }
}
