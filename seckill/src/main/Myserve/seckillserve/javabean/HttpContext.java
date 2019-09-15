package seckillserve.javabean;

import seckillserve.javamethod.getHttpDate;

public class HttpContext {
    private HttpRequest Request;
    private HttpResponse Response;
    private getHttpDate RequestDate;

    public HttpContext(String requestText)
    {
        Request = new HttpRequest(requestText);
        RequestDate = new getHttpDate(requestText);
        Response = new HttpResponse();
    }

    public getHttpDate getRequestDate() {
        return RequestDate;
    }

    public void setRequestDate(getHttpDate requestDate) {
        RequestDate = requestDate;
    }

    public void setRequest(HttpRequest request) {
        Request = request;
    }

    public void setResponse(HttpResponse response) {
        Response = response;
    }

    public HttpRequest getRequest() {
        return Request;
    }

    public HttpResponse getResponse() {
        return Response;
    }
}
