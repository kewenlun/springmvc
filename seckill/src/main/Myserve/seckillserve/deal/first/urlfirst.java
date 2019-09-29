package seckillserve.deal.first;


import bean.stru.buystru;
import bean.stru.buysucessstru;
import bean.stru.commodityinf;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import seckillserve.javabean.HttpContext;
import seckillserve.prestrain.springbean;



public class urlfirst {

    //路径为/seckill
    public JSONArray seckill(String url, HttpContext httpContext) throws Exception {
        String[] u = url.split("/");
        springbean prestrain = springbean.getInstance();
        JSONObject ax = httpContext.getRequestDate().getDate();//此处有一处输出
        JSONArray back = new JSONArray();
        //如果需要执行的不再本级中，则调用
        if (u.length > 3){
//            return new fangfa()//下一级的调用方法
            return null;
        }
        //这是seckill路径下buy；其中方法为seckill类中的buy方法
        else if (u[2].equals("buy") && u.length == 3){
            buystru a = JSON.toJavaObject(ax,buystru.class);
            back.add(JSON.toJSON(prestrain.getSeckill().buy(a)));
            return back;
        }
        else if (u[2].equals("delete")){
            buystru a = JSON.toJavaObject(ax,buystru.class);
            back.add(JSON.toJSON(prestrain.getSeckill().deletebuy(a)));
            return back;
        }
        else if (u[2].equals("findgoods")){
            commodityinf a = JSON.toJavaObject(ax,commodityinf.class);
            back.add(JSON.toJSON(prestrain.getSeckill().findone(a.getNumber())));
            return back;
        }
        else if (u[2].equals("seckillall")){
            back = (JSONArray) JSON.toJSON(prestrain.getSeckill().findall());
            return back;
        }
        else if (u[2].equals("pay")){
            buysucessstru a = JSON.toJavaObject(ax,buysucessstru.class);
            back.add(JSON.toJSON(prestrain.getSeckill().buysucess(a)));
            return back;
        }
        else if (u[2].equals("findbuy")){
            buystru a = JSON.toJavaObject(ax,buystru.class);
            System.out.println("我在这打印了一些东西");
            System.out.println(ax);
            System.out.println(a.getUsername());
            back = (JSONArray) JSON.toJSON(prestrain.getSeckill().findbuy(a));
            System.out.println(ax);
            return back;
        }
        else if (u[2].equals("findsucess")){
            buysucessstru a = JSON.toJavaObject(ax,buysucessstru.class);
            back = (JSONArray) JSON.toJSON(prestrain.getSeckill().findsucess(a));
            return back;
        }
        else {
            back = null;
            return back;
        }
    }
}
