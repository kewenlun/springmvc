package bean.control;


import bean.stru.couponstru;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/coupon")
public class coupon {
    private ApplicationContext context1 = new ClassPathXmlApplicationContext("bean.xml");

    @RequestMapping("/use")
    public void use(couponstru coupon){

    }
}
