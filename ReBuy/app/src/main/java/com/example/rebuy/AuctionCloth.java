package com.example.rebuy;

/**
 * Created by dell on 2019/6/7.
 */

public class AuctionCloth {
    String price;
    String person;
    Boolean isLove ;
    public AuctionCloth(String price,String person){
        this.price = price;
        this.person = person;
        isLove = false;
    }
    public String getPrice(){
        return price;
    }
    public String getPerson(){
        return person;
    }
    public Boolean getLove(){return isLove; }
    public void setLove(Boolean isLove){this.isLove = isLove;}
}
