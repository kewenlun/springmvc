package bean.stru;

import java.util.Date;

public class buysucessstru {
    private String  username = null;
    private  int number = 0;
    private String goodsname = null;
    private int count = 0;
    private int price = 0;
    private String address = null;
    private String buytime = null;

    public void setBuytime(String buytime){
        this.buytime = buytime;
    }

    public String getBuytime(){
        return buytime;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setGoodsname(String name) {
        this.goodsname = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getUsername() {
        return username;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return goodsname;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }
}
