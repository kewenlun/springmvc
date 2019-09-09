package datesource.tableserve;

import bean.stru.commodityinf;
import bean.stru.ton;
import datesource.dao.tabledao;
import datesource.dao.tableserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("commodityserve")
public class commodityserve implements tableserve<commodityinf> {
    @Qualifier("commoditycontrol")
    @Autowired
    private tabledao<commodityinf> ser;

    public void open() throws Exception {
        ser.open();
    }

    public void close() throws Exception {
        ser.close();
    }

    public commodityinf[] findall() throws Exception {
        return ser.findall();
    }

    public commodityinf[] findamore(commodityinf commodityinf) throws Exception {
        return ser.findamore(commodityinf);
    }

    public commodityinf findone(commodityinf commodityinf) throws Exception {
        return ser.findone(commodityinf);
    }

    public ton save(commodityinf commodityinf) throws Exception {
        ser.save(commodityinf);
        return null;
    }

    public ton deletall() throws Exception {
        ser.deletall();
        return null;
    }

    public ton deletone(commodityinf commodityinf) throws Exception {
        ser.deletone(commodityinf);
        return null;
    }

    public ton update(commodityinf commodityinf) throws Exception {
        ser.update(commodityinf);
        return null;
    }
}
