package datesource.dao;

import bean.stru.ton;
import org.springframework.stereotype.Service;

//持久层
@Service("tabledao")
public interface tableserve<T> {
    public void open () throws Exception;
    public void close() throws Exception;
    public T[] findall() throws Exception;
    public T[] findamore(T t) throws Exception;
    public T findone(T t) throws Exception;
    public ton save(T t) throws Exception;
    public ton deletall() throws Exception;
    public ton deletone(T t) throws Exception;
    public ton update(T t) throws Exception;
}
