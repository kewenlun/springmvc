package datesource.databaseControl;

import bean.stru.buystru;
import bean.stru.buysucessstru;
import datesource.dao.tabledao;
import datesource.source.coomdate;
import datesource.source.table;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Repository("buysucesscontrol")
public class buysucessuse implements tabledao<buysucessstru> {
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

    public buysucessstru[] findall() throws Exception {
        return new buysucessstru[0];
    }

    public buysucessstru[] findamore(buysucessstru buysucessstru) throws Exception {
        sql = "select * from "+Table.getBuysucess()+" where suser ='"
                +buysucessstru.getUsername()+"'";
        rs = stmt.executeQuery(sql);
        buysucessstru[] buysucessstrus = new buysucessstru[20];
        int y = 0;
        while (rs.next()){
            buysucessstru buy = new buysucessstru();
            buy.setUsername(rs.getString("suser").trim());
            buy.setNumber(rs.getInt("cnumber"));
            buy.setGoodsname(rs.getString("cname").trim());
            buy.setCount(rs.getInt("bcount"));
            buy.setPrice(rs.getInt("bprice"));
            buy.setAddress(rs.getString("address").trim());
            buy.setBuytime(rs.getString("buytime"));
            buysucessstrus[y] = buy;
            y++;
        }
        x = 1;
        rs.close();
        return buysucessstrus;
    }

    public buysucessstru findone(buysucessstru buysucessstru) throws Exception {
        System.out.println("执行了查询");
        return null;
    }

    public void save(buysucessstru buystru) throws Exception {
        sql = "insert into "+Table.getBuysucess()+" values('"
                +buystru.getUsername()+"',"
                +buystru.getNumber()+",'"
                +buystru.getName()+"',"
                +buystru.getCount()+","
                +buystru.getPrice()+",'"
                +buystru.getAddress()+"','"
                +buystru.getBuytime()+"')";
        stmt.addBatch(sql);
        System.out.println(sql);
    }

    public void deletall() throws Exception {

    }

    public void deletone(buysucessstru buystru) throws Exception {
        sql = "delete from "+Table.getBuysucess()+"' where suser ='"
                +buystru.getUsername()+"'";
        stmt.addBatch(sql);
    }

    public void update(buysucessstru buystru) throws Exception {

    }
}
