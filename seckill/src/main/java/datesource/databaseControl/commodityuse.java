package datesource.databaseControl;

import bean.stru.commodityinf;
import datesource.dao.tabledao;
import datesource.source.coomdate;
import datesource.source.table;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


@Repository("commoditycontrol")//持久层，对数据库进行操作
public class commodityuse implements tabledao<commodityinf> {
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
            rs.close();
            x = 0;
        }
        else {
            stmt.executeBatch();
        }
        stmt.close();
        coon.close();
    }

    public commodityinf[] findall() throws Exception {
        sql = "select * from "+table.getCommodityinf();
        rs = stmt.executeQuery(sql);
        int y = 0;
        commodityinf[] coom = new commodityinf[100];
        while (rs.next()){
            commodityinf commodityinf = new commodityinf();
            commodityinf.setNumber(rs.getInt("cnumber"));
            commodityinf.setName(rs.getString("cname").trim());
            commodityinf.setType(rs.getString("ctype").trim());
            commodityinf.setPrice(rs.getInt("cprice"));
            commodityinf.setCount(rs.getInt("ccount"));
            commodityinf.setImage(rs.getString("image").trim());
            coom[y] = commodityinf;
            y++;
        }
        commodityinf[] commodity = new commodityinf[y];
        for (int a = 0; a < y; a++){
            commodity[a] = coom[a];
        }
        return commodity;
    }

    public commodityinf[] findamore(commodityinf commodityinf) throws Exception {
        return new commodityinf[0];
    }

    public commodityinf findone(commodityinf comm) throws Exception {
        sql = "select * from "+ table.getCommodityinf()
                +" where cnumber ='"+comm.getNumber()+"'";
        rs = stmt.executeQuery(sql);
        while (rs.next()){
            comm.setName(rs.getString("cname"));
            comm.setType(rs.getString("ctype"));
            comm.setPrice(rs.getInt("cprice"));
            comm.setCount(rs.getInt("ccount"));
            comm.setImage(rs.getString("image"));
        }
        x = 1;
        return comm;
    }

    public void save(commodityinf comm) throws Exception {
        sql = "insert into "+table.getCommodityinf()+" values('"
                +comm.getNumber()+"','"
                +comm.getName()+"','"
                +comm.getType()+"','"
                +comm.getPrice()+"','"
                +comm.getCount()+"','"
                +comm.getImage()+"')";
        stmt.addBatch(sql);
    }

    public void deletall() throws Exception {

    }

    public void deletone(commodityinf comm) throws Exception {

    }

    public void update(commodityinf comm) throws Exception {
        sql = "update "+table.getCommodityinf()+" set ccount ='"+comm.getCount()
                +"' where cnumber ='"+comm.getNumber()+"'";
        stmt.addBatch(sql);
    }
}
