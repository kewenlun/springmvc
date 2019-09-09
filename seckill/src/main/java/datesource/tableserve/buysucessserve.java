package datesource.tableserve;


import bean.stru.buystru;
import bean.stru.buysucessstru;
import bean.stru.ton;
import datesource.dao.tabledao;
import datesource.dao.tableserve;
import datesource.databaseControl.buyuse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("buysucessserve")
public class buysucessserve implements tableserve<buysucessstru> {

    @Qualifier("buysucesscontrol")
    @Autowired
    private tabledao<buysucessstru> ser;
    public void open() throws Exception {
        ser.open();
    }

    public void close() throws Exception {
        ser.close();
    }

    public buysucessstru[] findall() throws Exception {
        return ser.findall();
    }

    public buysucessstru[] findamore(buysucessstru buysucessstru) throws Exception {
        return ser.findamore(buysucessstru);
    }

    public buysucessstru findone(buysucessstru buysucessstru) throws Exception {
        return ser.findone(buysucessstru);
    }

    public ton save(buysucessstru buysucessstru) throws Exception {
        ton a = new ton();
        buyuse ax = new buyuse();
        buystru buy = new buystru();
        buy.setUsername(buysucessstru.getUsername());
        buy.setNumber(buysucessstru.getNumber());
        ax.open();
        buy = ax.findone(buy);
        ax.close();
        if (buy.getUsername().equals("null")){
            a.setStat(0);
            a.setMessage("订单支付失败");
        }
        else {
            ser.save(buysucessstru);
            ax.open();
            ax.deletone(buy);
            ax.close();
            a.setStat(1);
            a.setMessage("订单支付成功");
        }
        return a;
    }

    public ton deletall() throws Exception {
        ser.deletall();
        return null;
    }

    public ton deletone(buysucessstru buysucessstru) throws Exception {
        ser.deletone(buysucessstru);
        return null;
    }

    public ton update(buysucessstru buysucessstru) throws Exception {
        ser.update(buysucessstru);
        return null;
    }
}
