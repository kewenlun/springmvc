package datesource.tableserve;

import bean.stru.buystru;
import bean.stru.commodityinf;
import bean.stru.ton;
import datesource.dao.tabledao;
import datesource.dao.tableserve;
import datesource.databaseControl.commodityuse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


//对buycar表进行超卓
@Service("buyserve")
public class buyserve implements tableserve<buystru> {

    @Qualifier("buycontrol")
    @Autowired
    private tabledao<buystru> ser;

    public void open() throws Exception {
        ser.open();
    }

    public void close() throws Exception {
        ser.close();
    }

    public buystru[] findall() throws Exception {
        return ser.findall();
    }

    public buystru[] findamore(buystru buystru) throws Exception {
        return ser.findamore(buystru);
    }

    public buystru findone(buystru buystru) throws Exception {
        return ser.findone(buystru);
    }

    public ton save(buystru buystru) throws Exception {
        commodityuse as = new commodityuse();
        ton a = new ton();
        commodityinf coom = new commodityinf();
        coom.setNumber(buystru.getNumber());
        as.open();
        as.findone(coom);
        as.close();
        if ((coom.getCount()-buystru.getCount()) >= 0){
            coom.setCount(coom.getCount()-buystru.getCount());
            as.open();
            as.update(coom);
            as.close();
            ser.save(buystru);
            a.setStat(1);
            a.setMessage("查询成功");
        }
        else {
            a.setStat(0);
            a.setMessage("查询失败");
            return a;
        }

        return a;
    }

    public ton deletall() throws Exception {
        ser.deletall();
        return new ton();
    }

    public ton deletone(buystru buystru) throws Exception {
        //如果看到这，说明还没有对数量进行返还
        ser.deletone(buystru);
        return new ton();
    }

    public ton update(buystru buystru) throws Exception {
        ser.update(buystru);
        return new ton();
    }
}
