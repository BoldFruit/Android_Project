package com.example.rebuy;

/**
 * Created by dell on 2019/6/7.
 */

public class AuctionCloth {
    String price;
    String person;
    public AuctionCloth(String price,String person){
        this.price = price;
        this.person = person;
    }
    public String getPrice(){
        return price;
    }
    public String getPerson(){
        return person;
    }
}
