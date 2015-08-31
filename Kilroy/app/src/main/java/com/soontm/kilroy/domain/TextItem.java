package com.soontm.kilroy.domain;

/**
 * Created by Florian on 25.08.2015.
 */
public class TextItem {
    private String text;
    private int userId;
    public int userId (){
        return userId;
    }
    public String getText(){
        return text;
    }
    public TextItem(String text, int userId){
        this.text=text;
        this.userId=userId;



    }

}
