package com.med.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.med.demo.model.Post;
import com.med.demo.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostServiceAdapter postServiceAdapter;

    @GetMapping("/{clientId}")
    public ResponseEntity<UpcomingPostsListResponse> getUpcomingPostsByClientId(@PathVariable Long clientId){

        UpcomingPostsListResponse upcomingPostListResponse = postServiceAdapter.getUpcomingPosts(clientId);
        upcomingPostListResponse = (UpcomingPostsListResponse) FortifyUtil.sanitizeResponseObject(upcomingPostListResponse, jacksonObjectMapper);

        return ResponseEntity.status(getHttpStatusFromProviderResponse(upcomingPostListResponse)).body(upcomingPostListResponse);

    }
}