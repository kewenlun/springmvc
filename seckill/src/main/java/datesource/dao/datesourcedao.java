package datesource.dao;

import org.springframework.stereotype.Repository;

//数据库信息存放接口
@Repository("datesource")//dao接口成
public interface datesourcedao {
    public String getname();
    public String geturl();
    public String getuser();
    public String getpassword();
}
