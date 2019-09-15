package seckillserve.javaserve;


import com.alibaba.fastjson.JSONObject;
import seckillserve.javabean.HttpContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class runserve {
    private static final int PORT = 12345;
    private ArrayList<Socket> mList = new ArrayList<Socket>();
    private ServerSocket server = null;
    private ExecutorService myExecutorService = null;

    public void server() throws IOException, InterruptedException {
        server = new ServerSocket(PORT);
        //创建线程池
        myExecutorService = Executors.newCachedThreadPool();
        System.out.println("服务端运行中...\n");
        Socket client = null;
        while(true)
        {
            client = server.accept();
            mList.add(client);
            System.out.println(mList.size());
            if (mList.size() <= 10000){
                myExecutorService.execute(new theadserver(client));
            }
            else {
                sleep(1000);
            }
        }
    }
    class theadserver implements Runnable {

        private Socket client = null;
        private BufferedReader data = null;

        public theadserver(Socket client){
            this.client = client;
        }

        public void run() {
            try {
                InputStreamReader is = new InputStreamReader(client.getInputStream(),"UTF-8");
                data = new BufferedReader(is);
                //把请求信息转换成字符串
                String requestText = getstring(data);
                JSONObject datesource = new JSONObject();
                HttpContext context = new HttpContext(requestText);
                //获取报文中post方式提交的数据
                datesource = context.getRequestDate().getPostDate();
                String url = context.getRequest().getUrl();
                client.close();
                mList.remove(client);
            }catch (Exception e){

            }
        }
        public String getstring(BufferedReader date) throws IOException {
            String msg = "";
            String asd = "";
            int x = 0;
            while ((msg = date.readLine()) != null){
                if (x == 0){
                    asd = msg + "\n";
                }
                else {
                    asd = asd + msg +"\n";
                }
                x++;
            }
            return asd;
        }
    }
}
