package seckillserve.javamethod;

import bean.control.login;
import bean.control.seckill;
import bean.stru.buystru;
import com.alibaba.fastjson.JSONObject;
import seckillserve.datechangImp.buy;
import seckillserve.datechangedao.changedao;
import seckillserve.javabean.HttpContext;
import seckillserve.javabean.HttpResponse;

import java.io.UnsupportedEncodingException;

public class urldeal {

    private HttpContext httpContext = null;
    private String url = null;

    public urldeal(String url, HttpContext httpContext){
        this.httpContext = httpContext;
        this.url = url;
    }

    public void deal() throws Exception {
        if (url.equals("/asd")){
            seckill as = new seckill();
            JSONObject ax = httpContext.getRequestDate().getPostDate();
            changedao<buystru> az = new buy();
            buystru a = new buystru();
            a = az.JsonToBean(ax);
            as.buy(a);
        }

    }
}
