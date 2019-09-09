import bean.control.login;
import bean.control.seckill;
import bean.stru.buystru;
import bean.stru.buysucessstru;
import bean.stru.commodityinf;

import datesource.dao.tableserve;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

    @Test
    public void sdf()throws Exception{
        buystru a = new buystru();
        ApplicationContext context1 = new ClassPathXmlApplicationContext("bean.xml");
        tableserve<buystru> ax = (tableserve<buystru>) context1.getBean("buyserve");
        ax.findone(a);

    }

    @Test
    public void dsf() throws Exception {
        seckill as = new seckill();
        buysucessstru sd = new buysucessstru();
        buysucessstru[] asd = new buysucessstru[20];
        sd.setUsername("sdfa");
        asd = as.findsucess(sd);
        for (int x = 0;x<3;x++){
            System.out.println(asd[x].getName());
        }
//        buysucessstru ad = new buysucessstru();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        ad.setUsername("sdf");
//        ad.setNumber(14);
//        ad.setGoodsname("耳机");
//        ad.setCount(1);
//        ad.setPrice(1999);
//        ad.setAddress("address");
//        String a = df.format(new Date());
//        System.out.println(a);
//        ad.setBuytime(a);
//        as.buysucess(ad);
    }


}
