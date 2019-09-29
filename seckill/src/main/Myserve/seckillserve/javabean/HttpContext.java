package seckillserve.javabean;

import seckillserve.javamethod.getHttpDate;

public class HttpContext {
    private HttpRequest Request;
    private HttpResponse Response;
    private getHttpDate RequestDate;
    private HttpCookie cookie;

    public HttpContext(String requestText) {
        Request = new HttpRequest(requestText);
        RequestDate = new getHttpDate(requestText);
        Response = new HttpResponse();
        cookie = new HttpCookie();
    }

    public void setCookie(HttpCookie cookie) {
        this.cookie = cookie;
    }

    public HttpCookie getCookie() {
        return cookie;
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
