package seckillserve.javabean;

import com.alibaba.fastjson.JSONArray;

public class HttpResponse
{
    // 响应状态码
    private String StateCode;
    // 响应状态描述
    private String StateDescription;
    // 响应内容类型
    private String ContentType;
    //响应内容
    private String ResponseText;

    private JSONArray ResponseJSON;

    public void setResponseText(String responseText) {
        ResponseText = responseText;
    }

    public void setResponseJSON(JSONArray responseJSON) {
        ResponseJSON = responseJSON;
    }

    public String getResponseText() {
        return ResponseText;
    }

    public JSONArray getResponseJSON() {
        return ResponseJSON;
    }

    public void setStateCode(String stateCode) {
        StateCode = stateCode;
    }

    public void setStateDescription(String stateDescription) {
        StateDescription = stateDescription;
    }

    public void setContentType(String contentType) {
        ContentType = contentType;
    }

    public String getStateCode() {
        return StateCode;
    }

    public String getStateDescription() {
        return StateDescription;
    }

    public String getContentType() {
        return ContentType;
    }

}
