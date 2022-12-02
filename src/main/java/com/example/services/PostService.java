package com.example.services;

import com.example.dao.PostDAO;
import com.example.model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements PostServiceInterface {
    @Autowired
    PostDAO postDAO;

    @Override
    public int insertPost(PostModel model) {
        return postDAO.insertBoard(model);
    }

    @Override
    public int deletePost(int id) {
        return postDAO.deleteBoard(id);
    }

    @Override
    public int updatePost(PostModel model) {
        return postDAO.updateBoard(model);
    }

    @Override
    public PostModel getPost(int id) {
        return postDAO.getBoard(id);
    }

    @Override
    public List<PostModel> getPostList() {
        return postDAO.getBoardList();
    }
}
