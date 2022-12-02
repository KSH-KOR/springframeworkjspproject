package com.example.controllers;

import com.example.model.PostModel;
import com.example.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/post")
public class PostController {
    @Autowired
    PostService postService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String boardList(Model model){
        model.addAttribute("modelList", postService.getPostList());
        return "list";
    }

    @RequestMapping(value = "/addpost", method = RequestMethod.GET)
    public String addPost(){
        return "addpostform";
    }

    @RequestMapping(value = "/editpost/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") int id, Model model){
        PostModel postModel = postService.getPost(id);
        model.addAttribute("editModelInfo", postModel);
        return "editpostform";
    }

    @RequestMapping(value = "/addpostok", method = RequestMethod.POST)
    public String addPostOk(PostModel postModel){
        if(postService.insertPost(postModel) == 0){
            System.out.println("데이터 추가 실패");
        } else{
            System.out.println("데이터 추가 성공");
        }
        return "redirect:list";
    }
    @RequestMapping(value = "/editpostok", method = RequestMethod.POST)
    public String editPostOk(PostModel postModel){
        if(postService.updatePost(postModel) == 0){
            System.out.println("데이터 수정 실패");
        } else{
            System.out.println("데이터 수정 성공");
        }
        return "redirect:list";
    }

    @RequestMapping(value = "/deletepost/{id}", method = RequestMethod.GET)
    public String deletePost(@PathVariable("id") int id){
        if(postService.deletePost(id) == 0){
            System.out.println("데이터 삭제 실패");
        } else{
            System.out.println("데이터 삭제 성공");
        }

        return "redirect:../list";
    }

}
