package com.example.rebuy;

/**
 * Created by dell on 2019/6/2.
 */

public class FirstpageClothes {
    private double price;
    private boolean isAction;
    private boolean isNoBargain;
    private boolean isExchangable;
    private boolean isLoved;

    public FirstpageClothes(double price,boolean isAction, boolean isNoBargain, boolean isExchangable, boolean isLoved){
        this.price = price;
        this.isAction = isAction;
        this.isNoBargain = isNoBargain;
        this.isExchangable = isExchangable;
        this.isLoved = isLoved;
    }

    public double getPrice(){
        return price;
    }
    public boolean getAuction(){
        return isAction;
    }
    public boolean getNoBargain(){
        return isNoBargain;
    }
    public boolean getExchangable(){
        return isExchangable;
    }
    public boolean getLoved(){
        return isLoved;
    }
    public void setLove(boolean isLoved){
        this.isLoved = isLoved;
    }
}
