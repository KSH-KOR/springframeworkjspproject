package com.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PostModel {
    private int id;
    private String title;
    private String writer;
    private String content;
    private int rate;

    private Date timestamp;

    public PostModel(){

    }

    public PostModel(ResultSet rs) throws SQLException {
        int id =rs.getInt("id");
        String content = rs.getString("content");
        String title = rs.getString("title");
        String writer = rs.getString("writer") != null ? rs.getString("writer") : "no name";
        Date date = rs.getDate("createdTime");
        setId(rs.getInt("id"));
        setContent(rs.getString("content"));
        setTitle(rs.getString("title"));
        setWriter(rs.getString("writer"));
        setRate(rs.getInt("rate"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        return "id: "+getId() + "| writer: " + getWriter() + "| title: " + getTitle() + "| content: " + getContent() + "| date: "+ getTimestamp();
    }
}
