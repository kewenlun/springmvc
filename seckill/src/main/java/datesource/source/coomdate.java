package datesource.source;

import datesource.dao.datesourcedao;
import org.springframework.stereotype.Repository;

@Repository("Coomdate")
public class coomdate implements datesourcedao {
    public static String name = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=commoodity";

    public static String user =  "zhao";

    public static String password = "zhao19970228";

    public String getname() {
        return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    }

    public String geturl() {
        return "jdbc:sqlserver://localhost:1433;DatabaseName=commoodity";
    }

    public String getuser() {
        return "zhao";
    }

    public String getpassword() {
        return "zhao19970228";
    }
}
