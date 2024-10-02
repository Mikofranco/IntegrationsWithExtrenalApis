package com.example.ApiConsumption.postService;

import com.example.ApiConsumption.dto.request.GetPostRequest;
import com.example.ApiConsumption.dto.response.GetPostResponse;

import java.util.List;
import java.util.Map;

public interface PostService {
    List<Map<String, Object>> getPosts();
    Map<String, Object> getPostById(int id);
    Map<String, Object> postPayload(Map<String, Object> payload);
    GetPostResponse getPostUsingRequest(int id);
}
