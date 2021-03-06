package seckillserve.javaserve;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import seckillserve.deal.Interf_url_deal;
import seckillserve.deal.datedeal.response;
import seckillserve.javabean.HttpContext;
import seckillserve.javabean.HttpResponse;
import seckillserve.prestrain.dispose;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

//服务器运行函数
public class runserve {
    private static final int PORT = 12345;
    private ArrayList<Socket> mList = new ArrayList<Socket>();
    private ServerSocket server = null;
    private ExecutorService myExecutorService = null;

    public void server() throws IOException, InterruptedException {

        //运行预加载的文件
        dispose az = new dispose();
        az.prestrain();

        server = new ServerSocket(PORT);
        //创建线程池
        myExecutorService = Executors.newCachedThreadPool();//这还可以再改进一下，容易oom溢出报错
        System.out.println("服务端运行中...\n");
        Socket client = null;
        while(true)
        {
            //接受连接
            client = server.accept();
            //加入线程池
            mList.add(client);
            //设置线程池内最大执行个数
            //当个数大于设置的数时，休息一定时间，再重新执行
            System.out.println(mList.size());
            if (mList.size() <= 1000){

                System.out.println(mList.size()+"??????");
                //把接受到的连接交给线程执行
                myExecutorService.execute(new theadserver(client));
//                new theadserver(client);
            }
            else {
                sleep(1000);
//                myExecutorService.execute(new theadserver(client,is,));
            }
            client = null;
        }
    }
    //线程执行
    class theadserver implements Runnable {

        private Socket client = null;

        public theadserver(Socket client){
            this.client = client;
//            send();

        }

        public void run() {
            try {
                // 把请求信息转换成字符串
                String requestText = "";
                InputStream is = client.getInputStream();
                InputStreamReader data1 = new InputStreamReader(is, "UTF-8");
                BufferedReader date = new BufferedReader(data1);
                //获取HTTP报文并把它转换成String类型
                requestText = getstring(date);
                System.out.println("我在这打印一下接收到的报文");
                System.out.println(requestText);

                JSONObject datesource = new JSONObject();
                HttpContext context = new HttpContext(requestText);

                Interf_url_deal s = new Interf_url_deal(context.getRequest().getUrl(),context);
                JSONArray datesour = s.deal();
                System.out.println("在此处输出一下返回的信息");
                System.out.println(datesour);
                sendCookie(context);
                send(datesour);

                mList.remove(client);
                client.close();
            }catch (Exception e){

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
                    requestText = String.valueOf(b);
                    break;
                }
            }
            return requestText;
        }

        public void send(JSONArray datesour){

            HttpResponse httpResponse = new response().datedeal(datesour);
            if(datesour.size() == 1){
                JSONObject senddate = datesour.getJSONObject(0);
                try {
                    client.getOutputStream().
                            write(("HTTP/1.1 "+httpResponse.getStateCode()+" "+httpResponse.getStateDescription()+"\r\n" +  //响应头第一行
                                    "Content-Type: application/json; charset=utf-8\r\n" +  //简单放一个头部信息
                                    "\r\n" +  //这个空行是来分隔请求头与请求体的
                                    senddate).getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    client.getOutputStream().
                            write(("HTTP/1.1 "+httpResponse.getStateCode()+" "+httpResponse.getStateDescription()+"\r\n" +  //响应头第一行
                                    "Content-Type: application/json; charset=utf-8\r\n" +  //简单放一个头部信息
                                    "\r\n" +  //这个空行是来分隔请求头与请求体的
                                    datesour).getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                mList.remove(client);
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void sendCookie(HttpContext httpContext) throws IOException {
            if (httpContext.getCookie().getName() == null){
                System.out.println("HELLO ERVERYPNE");
            }
            else {
                client.getOutputStream().
                    write(("HTTP/1.1 200 OK\r\n" +  //响应头第一行
                            "Content-Type: text/json; charset=UTF-8\r\n" +  //简单放一个头部信息
                            "Set-Cookie: "+httpContext.getCookie().getName()+"="+httpContext.getCookie().getValues()+
                            ";path=/;max-age="+httpContext.getCookie().getMaxage()+"\r\n" //这个空行是来分隔请求头与请求体的
                            +"\r\n"
                    ).getBytes());
            }

        }
    }
}
