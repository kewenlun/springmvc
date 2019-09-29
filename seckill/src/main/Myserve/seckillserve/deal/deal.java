package seckillserve.deal;

import com.alibaba.fastjson.JSONArray;
import seckillserve.javabean.HttpContext;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class deal {


    public int urldeal(String url, HttpContext context) throws Exception {
        int x = url.indexOf(".");
        if (x == -1){
            Interf_url_deal as = new Interf_url_deal(url,context);
            JSONArray a = new JSONArray();
            a = as.deal();
            context.getResponse().setResponseJSON(a);
            //代表处理的是接口
            return 1;
        }
        else {
            String name = "C:\\Users\\赵文超\\IdeaProjects\\seckill\\src\\main\\webapp";
            String na = url.replace("/","\\");
            File l = new File(name+na);
            if (!l.exists()){
                context.getResponse().setResponseText("");
            }
            else {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(name+na));
                String file = getstring(bufferedReader);
                context.getResponse().setResponseText(file);
            }
            return 2;
        }
    }


    public String getstring(BufferedReader date) throws IOException {
        String requestText = "";
        char[] a = new char[1024];
        int off = 0;
        while (true){
            int x = date.read(a,off,a.length);
            if (x == a.length){
                requestText = requestText + String.valueOf(a);
                a = new char[1024];
            }
            else {
                char[] b = new char[x];
                for (int m = 0; m < x;m++){
                    b[m] = a[m];
                }
                requestText = requestText + String.valueOf(b);
                break;
            }
        }
        return requestText;
    }
}
