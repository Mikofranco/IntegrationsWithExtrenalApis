package com.example.ApiConsumption.postService;

import com.example.ApiConsumption.config.RestTemplateService;
import com.example.ApiConsumption.dto.request.GetPostRequest;
import com.example.ApiConsumption.dto.response.GetPostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private RestTemplateService restTemplateService;

    private final String baseUrl = "https://jsonplaceholder.typicode.com";
    private final String POST = "/posts";

    @Override
    public List<Map<String, Object>> getPosts() {
        HttpEntity<Void> httpEntity = new HttpEntity<>(getHttpHeaders());
        String url = baseUrl + POST;
        var response = restTemplateService.restTemplate().exchange(url, HttpMethod.GET, httpEntity, List.class);
        return response.getBody();
    }

    @Override
    public Map<String, Object> getPostById(int id) {
        HttpEntity<Void> httpEntity = new HttpEntity<>(getHttpHeaders());
        String url = baseUrl + POST+"/"+id;
        System.out.println(url);
        var response = restTemplateService.restTemplate().exchange(url, HttpMethod.GET, httpEntity, Map.class);
        return response.getBody();
    }

    @Override
    public Map<String, Object> postPayload(Map<String, Object> payload) {
        HttpEntity<Map> httpEntity = new HttpEntity<>(payload, getHttpHeaders());
        String url = baseUrl + "post";
        var response = restTemplateService.restTemplate().exchange(url, HttpMethod.POST, httpEntity, Map.class);
        return response.getBody();
    }

    @Override
    public GetPostResponse getPostUsingRequest(int  id) {
        HttpEntity<Void> httpEntity = new HttpEntity<>(getHttpHeaders());
        String url = baseUrl + POST+"/"+id;
        var response = restTemplateService.restTemplate().exchange(url, HttpMethod.GET, httpEntity, GetPostResponse.class);
        return response.getBody();
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}
