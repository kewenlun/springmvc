package seckillserve.javamethod;

import com.alibaba.fastjson.JSON;
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

    //判断get和post提交方式
    public JSONObject getDate() throws UnsupportedEncodingException {
        String[] lines = requestText.replace("\n", "\r").split("\r");
        String[] requestLines = lines[0].split(" ");
        String datetype = requestLines[0];
        if (datetype.equals("POST")){
            return getPostDate();
        }
        else {
            System.out.println("我在这处理get方法");
            return getGetDate();
        }
    }

    //获取http报文中GET方式中的参数，并且以JSON的格式返回报文中的信息
    public JSONObject getGetDate() throws UnsupportedEncodingException {
        JSONObject datevalue = new JSONObject();
        String[] lines = requestText.split("\n");
        String[] request = lines[0].split(" ");
        int x = request[1].indexOf("?");
        if (x == -1){
            return null;
        }
        else {
            String[] date = request[1].replace("?","ASDF").split("ASDF");
            int y = date[1].indexOf("&");
            if (y == -1){
                String[] l = date[1].split("=");
                datevalue.put(l[0],l[1]);
            }
            else {
                String[] l = date[1].split("&");
                for (int z = 0; z < l.length; z++){
                    String[] m = l[z].split("=");
                    datevalue.put(m[0],m[1]);
                }
            }
        }
        return datevalue;
    }

    //获取http报文中POST方式中的参数，并且以JSON的格式返回报文中的信息
    public JSONObject getPostDate() throws UnsupportedEncodingException {
        JSONObject datevalue = new JSONObject();
        String[] lines = requestText.split("\n");
        String[] type1 = requestText.split("ype: ");
        String[] type = type1[1].split("\n");
        String[] datetype = type[0].split(";");
        if (datetype[0].replace("\r","").equals("application/json")){
            System.out.println("我处理的是json格式数据");
            datevalue = deal_JSON(requestText);
        }
        else if (datetype[0].replace("\r","").equals("application/x-www-form-urlencoded")){
            System.out.println("我处理的是url格式数据");
            datevalue = deal_URLencodeed(lines);
        }
        else {
            System.out.println("我什么格式的数据也没有处理");
        }
        return datevalue;
    }

    //处理数据类型是post提交方式url编码格式发来的http报文
    public JSONObject deal_URLencodeed(String[] lines) throws UnsupportedEncodingException {
        JSONObject datevalue = new JSONObject();
        String l = lines[lines.length-1];
        if (lines.length > 10){
            String[] date = l.split("&");
            if (date.length <= 1){
                String[] value = date[0].split("=");
                if (value.length <= 1){
                }
                else {
                    String a = URLDecoder.decode(value[1],"utf-8");
                    datevalue.put(value[0],a);
                }
            }
            for (int x = 0; x < date.length; x++){
                String[] value = date[x].split("=");
                String a = URLDecoder.decode(value[1],"utf-8");
                datevalue.put(value[0],a);
            }
        }
        return datevalue;
    }

    //处理数据类型是post提交方式JSON编码格式发来的http报文
    public JSONObject deal_JSON(String requestText){
        String l = requestText.replace("\n"," ");
        String[] a = l.replace("\r","ASDF").split("ASDF");
        JSONObject datevalue = new JSONObject();
        datevalue = JSON.parseObject(a[a.length-1]);
        return datevalue;
    }
}
