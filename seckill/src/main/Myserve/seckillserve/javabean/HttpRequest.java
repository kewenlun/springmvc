package seckillserve.javabean;


public class HttpRequest
{
    // 请求方式：GET or POST?
    private String HttpMethod;
    // 请求URL
    private String Url;
    // Http协议版本
    private String HttpVersion;
    // 请求头
    public HttpRequest(String requestText) {
        String[] lines = requestText.replace("\n", "\r").split("\r");
        String[] requestLines = lines[0].split(" ");
        // 获取HTTP请求方式、请求的URL地址、HTTP协议版本
        HttpMethod = requestLines[0];
        System.out.println("我已经读到了HTTP请求方式"+HttpMethod);
        int x = requestLines[1].indexOf("?");
        if (x == -1){
            //String[] a = requestLines[1].split("/api");
            Url = requestLines[1];
        }
        else {
            String[] a = requestLines[1].replace("?","ASDF").split("ASDF");
            Url = a[0];
        }
        System.out.println("我读到了请求地址"+Url);
        HttpVersion = requestLines[2];
        System.out.println("我读到了HTTP协议"+HttpVersion);
        System.out.println(lines.length);
    }

    public void setHttpMethod(String httpMethod) {
        HttpMethod = httpMethod;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public void setHttpVersion(String httpVersion) {
        HttpVersion = httpVersion;
    }

    public String getHttpMethod() {
        return HttpMethod;
    }

    public String getUrl() {
        return Url;
    }

    public String getHttpVersion() {
        return HttpVersion;
    }

}
