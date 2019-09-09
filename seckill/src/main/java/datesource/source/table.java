package datesource.source;

public class table {
    //登陆信息表
    private String userinf = "userinf";
    //商品表
    private String commodityinf = "commodityinf";
    //支付表
    private String buyinf = "buycar";
    //订单表
    private String buysucess = "buysucess";
    //优惠券表
    private String coupon = "coupon";

    public String getBuysucess() {
        return buysucess;
    }

    public String getCoupon() {
        return coupon;
    }

    public String getUserinf() {
        return userinf;
    }

    public String getCommodityinf() {
        return commodityinf;
    }

    public String getBuyinf() {
        return buyinf;
    }
}
