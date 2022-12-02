package com.example.services;

import com.example.model.PostModel;

import java.util.List;

public interface PostServiceInterface {
    public int insertPost(PostModel model);
    public int deletePost(int id);
    public int updatePost(PostModel model);
    public PostModel getPost(int id);
    public List<PostModel> getPostList();
}
