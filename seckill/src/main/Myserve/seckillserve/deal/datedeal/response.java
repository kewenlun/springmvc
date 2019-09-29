package seckillserve.deal.datedeal;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import seckillserve.javabean.HttpResponse;

public class response {
    public HttpResponse datedeal(JSONArray jsonArray){
        HttpResponse httpResponse = new HttpResponse();
        if (jsonArray == null){
            httpResponse.setStateCode("404");
            return httpResponse;
        }
        else {
            httpResponse.setStateCode("200");
            httpResponse.setStateDescription("OK");
            httpResponse.setContentType(jsonArray.toJSONString());
        }

        return httpResponse;
    }
}
