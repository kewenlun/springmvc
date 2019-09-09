package bean.control;

import bean.stru.buystru;
import bean.stru.buysucessstru;
import bean.stru.commodityinf;
import bean.stru.ton;
import datesource.dao.tableserve;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/seckill")
public class seckill {
    ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");


    @RequestMapping("/buy")
    //创建订单；需要buystru类中的所有元素
    public @ResponseBody ton buy (@RequestBody buystru buy) throws Exception{
        tableserve<buystru> ax = (tableserve<buystru>)context.getBean("buyserve");
        ton a = new ton();
        //这里还缺对buycar表中的原属进行查询
        ax.open();
        a = ax.save(buy);
        ax.close();
        return a;
    }

    //删除订单；需要username和number，其中number为物品编号
    @RequestMapping("/delete")
    public @ResponseBody ton deletebuy(@RequestBody buystru buy) throws Exception {
        tableserve<buystru> ax = (tableserve<buystru>)context.getBean("buyserve");
        ton a = new ton();
        ax.open();
        a = ax.deletone(buy);
        ax.close();
        return a;
    }

    //查找商品；需要number原属  为商品编号
    @RequestMapping(path = "findgoods",method = RequestMethod.GET)
    public @ResponseBody commodityinf findone(int number) throws Exception {
        tableserve<commodityinf> ax = (tableserve<commodityinf>)context.getBean("commodityserve");
        commodityinf comm = new commodityinf();
        comm.setNumber(number);
        System.out.println(comm.getNumber());
        ax.open();
        comm = ax.findone(comm);
        ax.close();
        return comm;
    }

    @RequestMapping("seckillall")//查询所有秒杀商品
    public @ResponseBody commodityinf[] findall() throws Exception
    {
        tableserve<commodityinf> ax = (tableserve<commodityinf>)context.getBean("commodityserve");
        commodityinf[] commodity = new commodityinf[100];
        ax.open();
        commodity = ax.findall();
        ax.close();
        return commodity;
    }

    //这里需要buysucessstru类中的所有元素
    //支付订单
    @RequestMapping("pay")
    public @ResponseBody ton buysucess(@RequestBody buysucessstru buysucess) throws Exception {
        tableserve<buysucessstru> ax = (tableserve<buysucessstru>)context.getBean("buysucessserve");
        ton a = new ton();
        ax.open();
        a = ax.save(buysucess);
        ax.close();
        return a;
    }


    //这里需要username
    //查看未完成订单
    @RequestMapping("findbuy")
    public @ResponseBody buystru[] findbuy(@RequestBody buystru buy) throws Exception {
        tableserve<buystru> ax = (tableserve<buystru>)context.getBean("buyserve");
        buystru[] buys = new buystru[20];
        ax.open();
        buys = ax.findamore(buy);
        ax.close();
        return buys;
    }


    //这里需要username
    //查看历史订单
    @RequestMapping("findsucess")
    public @ResponseBody buysucessstru[] findsucess(@RequestBody buysucessstru buysucess) throws Exception {
        tableserve<buysucessstru> ax = (tableserve<buysucessstru>)context.getBean("buysucessserve");
        buysucessstru[] buys = new buysucessstru[20];
        ax.open();
        buys = ax.findamore(buysucess);
        ax.close();
        return buys;
    }

}
