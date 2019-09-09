package datesource.databaseControl;

import bean.stru.userstru;
import datesource.dao.tabledao;
import datesource.source.coomdate;
import datesource.source.table;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//admin表的操作（增，减，改，查）
@Repository("admincontrol")//持久层，对数据库进行操作
public class adminuse implements tabledao<userstru> {
    private int x = 0;//标识
    private Connection coon = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String sql = null;
    private table table = new table();
    public void open() throws Exception{
        coomdate admin = new coomdate();
        Class.forName(admin.getname());
        coon = DriverManager.getConnection(admin.geturl(),admin.getuser(),admin.getpassword());
        stmt=coon.createStatement();
    }

    public void close() throws Exception{
        if (x == 1){
            x = 0;
        }
        else {
            stmt.executeBatch();
        }
        stmt.close();
        coon.close();
    }

    public userstru[] findall() throws Exception {
       return null;
    }

    public userstru[] findamore(userstru userstru) throws Exception {
        return new userstru[0];
    }

    public userstru findone(userstru user) throws Exception{
        sql = "select * from "+table.getUserinf()+" where suser ='"+user.getName()+"'";
        rs = stmt.executeQuery(sql);
        x = 1;
        if (rs.next()){
            user.setId(rs.getString("spassword").trim());
        }
        else {
            user.setName("null");
            user.setId("null");
        }
        rs.close();
        return user;
    }

    public void save(userstru user) throws Exception{
        sql = "insert into "+table.getUserinf()+" values('"+user.getName()+"','"
               +user.getId()+"')";
       stmt.addBatch(sql);
//        stmt.executeUpdate(sql);
    }

    public void deletall() throws Exception{
        sql = "delete from "+table.getUserinf();
        stmt.addBatch(sql);
    }

    public void deletone(userstru user) throws Exception{
        sql = "delete from "+table.getUserinf()+" where suser ='"+user.getName()+"'";
        stmt.addBatch(sql);
    }

    public void update(userstru user) {

    }

}
