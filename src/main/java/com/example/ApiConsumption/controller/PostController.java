package com.example.ApiConsumption.controller;

import com.example.ApiConsumption.dto.response.GetPostResponse;
import com.example.ApiConsumption.postService.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/getPost")
    public List<Map<String, Object>> getAllPost() {
        return postService.getPosts();
    }

    @GetMapping("/getPostById/{id}")
    public Map<String, Object> getPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @GetMapping("/getPostByIdResponse/{id}")
    public ResponseEntity<GetPostResponse> getPostByIdResponse(@PathVariable int id) {
        GetPostResponse response = postService.getPostUsingRequest(id);
        return ResponseEntity.ok(response);
    }
}
