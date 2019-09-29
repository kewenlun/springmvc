package seckillserve.deal;

import bean.stru.userstru;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import seckillserve.javabean.HttpContext;
import seckillserve.deal.first.urlfirst;
import seckillserve.prestrain.springbean;


public class Interf_url_deal {

    private HttpContext httpContext = null;
    private String url = null;
    springbean prestrain = springbean.getInstance();

    public Interf_url_deal(String url, HttpContext httpContext){
        this.httpContext = httpContext;
        this.url = url;
    }

    public JSONArray deal() throws Exception {
        String[] a = url.split("/api");
        String[] u = a[1].split("/");
        if (u[1].equals("seckill")){
            urlfirst deal = new urlfirst();
            return deal.seckill(a[1],httpContext);
        }
        else if (u[1].equals("Login1")){
            JSONArray back = new JSONArray();
            JSONObject ax = httpContext.getRequestDate().getDate();
            userstru as = JSON.toJavaObject(ax,userstru.class);
            back.add(JSON.toJSON(prestrain.getLogin().login1(as,httpContext.getCookie())));
            return back;
        }
        else if (u[1].equals("Login_out")){
            JSONArray back = new JSONArray();
            back.add(JSON.toJSON(prestrain.getLogin().login_out(httpContext.getCookie())));
            return back;
        }
        else {
            JSONArray back = new JSONArray();
            back = null;
            return back;
        }
    }
}
