package seckillserve.javabean;

import org.omg.IOP.Encoding;

import java.io.UnsupportedEncodingException;

public class HttpResponse
{
    // 响应状态码
    private String StateCode;
    // 响应状态描述
    private String StateDescription;
    // 响应内容类型
    private String ContentType;
    //响应报文的正文内容
    private String respondText = null;

    public void setRespondText(String respondText){
        this.respondText = respondText;
    }

    public String getRespondText(){
        return respondText;
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
