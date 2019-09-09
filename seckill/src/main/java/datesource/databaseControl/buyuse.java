package datesource.databaseControl;

import bean.stru.buystru;
import datesource.dao.tabledao;
import datesource.source.coomdate;
import datesource.source.table;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//对buycar表进行超卓
@Repository("buycontrol")//持久层，对数据库进行操作
public class buyuse implements tabledao<buystru> {
    private int x = 0;//标识
    private Connection coon = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String sql = null;
    private table Table = new table();
    public void open() throws Exception {
        coomdate admin = new coomdate();
        Class.forName(admin.getname());
        coon = DriverManager.getConnection(admin.geturl(),admin.getuser(),admin.getpassword());
        stmt=coon.createStatement();
    }

    public void close() throws Exception {
        if (x == 1){
            x = 0;
        }
        else {
            stmt.executeBatch();
        }
        stmt.close();
        coon.close();
    }

    public buystru[] findall() throws Exception {
        return new buystru[0];
    }

    public buystru[] findamore(buystru buystru) throws Exception {
        sql = "select * from "+Table.getBuyinf()+" where suser ='"
                +buystru.getUsername()+"'";
        rs = stmt.executeQuery(sql);
        buystru[] buys = new buystru[20];
        int y = 0;
        while (rs.next()){
            buystru buy = new buystru();
            buy.setUsername(rs.getString("suser").trim());
            buy.setNumber(rs.getInt("cnumber"));
            buy.setGoodsname(rs.getString("cname").trim());
            buy.setCount(rs.getInt("bcount"));
            buy.setPrice(rs.getInt("bprice"));
            buy.setAddress(rs.getString("buyaddress").trim());
            buys[y] = buy;
            y++;
        }
        rs.close();
        x = 1;
        return buys;
    }

    public buystru findone(buystru buystru) throws Exception {
        System.out.println("执行了查询");
        sql = "select cname from "+Table.getBuyinf()+" where suser ='"
                +buystru.getUsername()+"' and cnumber ="
                +buystru.getNumber();
        rs = stmt.executeQuery(sql);
        if (rs.next()){
            return buystru;
        }
        else {
            buystru.setUsername("null");
        }
        return buystru;
    }

    public void save(buystru buystru) throws Exception {
        sql = "insert into "+Table.getBuyinf()+" values('"
                +buystru.getUsername()+"','"
                +buystru.getNumber()+"','"
                +buystru.getName()+"','"
                +buystru.getCount()+"','"
                +buystru.getPrice()+"','"
                +buystru.getAddress()+"')";
        stmt.addBatch(sql);
    }

    public void deletall() throws Exception {

    }

    public void deletone(buystru buystru) throws Exception {
        sql = "delete from "+Table.getBuyinf()+" where suser ='"
                +buystru.getUsername()+"' and "
                +"cnumber ="
                +buystru.getNumber();
        stmt.addBatch(sql);
    }

    public void update(buystru buystru) throws Exception {

    }


}
