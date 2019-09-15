package seckillserve.datechangImp;

import bean.stru.buystru;
import bean.strusource.strusource;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import seckillserve.datechangedao.changedao;

public class buy implements changedao<buystru> {

    public JSONObject BeanToJson(buystru buystru) {
        return null;
    }

    public buystru JsonToBean(JSONObject t) {
        strusource as = new strusource();
        buystru ax = new buystru();
        String[] name = new String[as.getBuy().length];
        name = as.getBuy();
        ax.setUsername(t.getString(name[0]));
        ax.setNumber(t.getIntValue(name[1]));
        ax.setGoodsname(t.getString(name[2]));
        ax.setCount(t.getIntValue(name[3]));
        ax.setPrice(t.getIntValue(name[4]));
        ax.setAddress(t.getString(name[5]));
        return ax;
    }

    public JSONArray BeansToJsonArray(buystru[] t) {
        return null;
    }

    public buystru[] JsonArrayToBeans(JSONArray t) {
        return new buystru[0];

    }
}
