package datesource.tableserve;

import bean.stru.ton;
import bean.stru.userstru;
import datesource.dao.tabledao;
import datesource.dao.tableserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


//admin表的操作（增，减，改，查）
@Service("userserve")//服务ceng
public class userserve implements tableserve<userstru> {

    @Qualifier("admincontrol")
    @Autowired
    private tabledao<userstru> ser;
    //打开数据库链接
    public void open() throws Exception{
        ser.open();
    }
    //关闭数据库连接
    public void close() throws Exception{
        ser.close();
    }
    //查找表中所有信息
    public userstru[] findall() throws Exception {
       return ser.findall();
    }
    //查找表中多个信息
    public userstru[] findamore(userstru userstru) throws Exception {
        return ser.findamore(userstru);
    }
    //查找表中一条信息
    public userstru findone(userstru user) throws Exception{
       return ser.findone(user);
    }
    //保存信息到数据库
    public ton save(userstru user) throws Exception{
       ser.save(user);
        return null;
    }
    //
    public ton deletall() throws Exception{
        ser.deletall();
        return null;
    }

    public ton deletone(userstru user) throws Exception{
        ser.deletone(user);
        return null;
    }

    public ton update(userstru user) throws Exception {
        ser.update(user);
        return null;
    }

}
