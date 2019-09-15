package seckillserve.javamethod;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class getHttpDate {

    private String requestText = null;

    public getHttpDate(String requestText){
        this.requestText = requestText;
    }

    //获取http报文中GET方式中的参数，并且以JSON的格式返回报文中的信息
    public void getGetDate(){

    }

    //获取http报文中POST方式中的参数，并且以JSON的格式返回报文中的信息
    public JSONObject getPostDate() throws UnsupportedEncodingException {
        JSONObject datevalue = new JSONObject();
//        JSONArray datearray = new JSONArray();
//        System.out.println(requestText);
        String[] lines = requestText.replace("\n", "\r").split("\r");
        if (lines.length > 10){
            String[] date = lines[lines.length-1].split("&");
            for (int x = 0; x < date.length; x++){
                String[] value = date[x].split("=");
                String a = URLDecoder.decode(value[1],"utf-8");
                datevalue.put(value[0],a);
            }
        }
        System.out.println(datevalue);
        return datevalue;
    }
}
