package com.example.litepaltest;

import org.litepal.crud.DataSupport;

/**
 * Created by dell on 2019/5/5.
 */

public class Book extends DataSupport{
    private int id;
    private String author;
    private double price;
    private int pages;
    private  String name;
    private String press;
    public String getPress(){
        return press;
    }
    public void setPress(String press){
        this.press = press;
    }
    public int getId(){
        return id;
    }
    public String getAuthor(){
        return author;
    }
    public double getPrice(){
        return price;
    }
    public  int getPages(){
        return pages;
    }
    public String getName(){
        return name;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setPages(int pages){
        this.pages = pages;
    }
    public void setName(String name){
        this.name = name;
    }
}
