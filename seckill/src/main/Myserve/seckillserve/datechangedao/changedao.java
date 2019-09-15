package seckillserve.datechangedao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface changedao<T> {
    public JSONObject BeanToJson(T t);
    public T JsonToBean(JSONObject t);
    public JSONArray BeansToJsonArray(T[] t);
    public T[] JsonArrayToBeans(JSONArray t);
}
