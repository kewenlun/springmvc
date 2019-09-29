package seckillserve.javabean;

public class HttpCookie {
    private String name = null;
    private String values = null;
    private String maxage = null;

    public void setName(String name) {
        this.name = name;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public void setMaxage(String maxage) {
        this.maxage = maxage;
    }

    public String getName() {
        return name;
    }

    public String getValues() {
        return values;
    }

    public String getMaxage() {
        return maxage;
    }

    public void send(){

    }
}
