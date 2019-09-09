package datesource.dao;

import org.springframework.stereotype.Repository;



//持久层
@Repository
public interface tabledao<T> {
    //打开连接
    public void open () throws Exception;
    //关闭连接
    public void close() throws Exception;
    //查找表中所有信息
    public T[] findall() throws Exception;
    //查找表中多条信息
    public T[] findamore(T t) throws Exception;
    //查找表中一条信息
    public T findone(T t) throws Exception;
    //保存数据到数据库表中
    public void save(T t) throws Exception;
    //删除表
    public void deletall() throws Exception;
    //删除表中信息
    public void deletone(T t) throws Exception;
    //更新数据
    public void update(T t) throws Exception;
}
