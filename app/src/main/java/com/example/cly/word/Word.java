package com.example.cly.word;

import java.io.Serializable;

public class Word implements Serializable {
    int id;
    String name;
    String meaning;
    String sample;
    String update;
    String collect;
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getMeaning(){
        return meaning;
    }
    public void setMeaning(String meaning){
        this.meaning=meaning;
    }
    public String getSample(){
        return sample;
    }
    public void setSample(String sample){
        this.sample=sample;
    }
    public String getUpdate(){
        return update;
    }
    public void setUpdate(String update){
        this.update=update;
    }
    public String getCollect(){
        return collect;
    }
    public void setCollect(String collect){
        this.collect=collect;
    }
}
