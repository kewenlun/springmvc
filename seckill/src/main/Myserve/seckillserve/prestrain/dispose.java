package seckillserve.prestrain;

import bean.control.login;
import bean.control.seckill;

//关于对预加载的配置信息
public class dispose {
    public void prestrain(){
        seckill as = new seckill();
        login ax = new login();
        springbean prestrain = springbean.getInstance();
        prestrain.setSeckill(as);
        prestrain.setLogin(ax);
    }
}
