package seckillserve.prestrain;

import bean.control.login;
import bean.control.seckill;

public class springbean {
    private seckill seckill = null;
    private login login = null;

    public bean.control.login getLogin() {
        return login;
    }

    public void setLogin(bean.control.login login) {
        this.login = login;
    }

    public bean.control.seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(bean.control.seckill seckill) {
        this.seckill = seckill;
    }

    private springbean() {
    }
    private static springbean s = new springbean();
    public static springbean getInstance() {
        return s;
    }
}
