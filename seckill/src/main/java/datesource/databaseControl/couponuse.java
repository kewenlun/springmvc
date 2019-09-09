package datesource.databaseControl;

import bean.stru.couponstru;
import datesource.dao.tabledao;
import datesource.source.coomdate;
import datesource.source.table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class couponuse implements tabledao<couponstru> {

    private int x = 0;//标识
    private Connection coon = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String sql = null;
    private table Table = new table();
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

    public couponstru[] findall() throws Exception {
        return new couponstru[0];
    }

    public couponstru[] findamore(couponstru couponstru) throws Exception {
        sql = "select * from "+Table.getCoupon()+" where suser ='"
                +couponstru.getUsername()+"' and fullcount <="
                +couponstru.getFull()+"'";
        rs = stmt.executeQuery(sql);
        int y = 0;
        couponstru[] coupon = new couponstru[20];
        while (rs.next()){
            couponstru c = new couponstru();
            c.setUsername(rs.getString("suser").trim());
            c.setCut(rs.getInt("fullcount"));
            c.setCut(rs.getInt("cutcount"));
            coupon[y] = c;
            y++;
        }
        return coupon;
    }

    public couponstru findone(couponstru couponstru) throws Exception {
        return null;
    }

    public void save(couponstru couponstru) throws Exception {

    }

    public void deletall() throws Exception {

    }

    public void deletone(couponstru couponstru) throws Exception {

    }

    public void update(couponstru couponstru) throws Exception {

    }
}
