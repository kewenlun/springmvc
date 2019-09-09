package bean.stru;

import org.springframework.stereotype.Service;

//admin表的数据格式
@Service("admintablesource")
public class userstru {
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
