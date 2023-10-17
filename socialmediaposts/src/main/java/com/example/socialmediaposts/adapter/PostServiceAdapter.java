package com.med.demo.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class PostServiceAdapter {

    @Autowired
    private PostDataService postDataService;

    @Autowired
    private PostDomainToProvider postDomainToProvider;

    @Autowired
    private PostProviderToDomain postProviderToDomain;

    @Autowired
    private PostRequestValidator postRequestValidator;

    public UpcomingPostsListResponse getUpcomingPostsByClientId(Long clientId){

        UpcomingPostsListResponse upcomingPostsListResponse = new UpcomingPostsListResponse();
        UpcomingPostsListDomainResponse upcomingPostsListDomainResponse = new UpcomingPostsListDomainResponse();


        upcomingPostsListDomainResponse = postDataService.getUpcomingPostsByClientId(clientId);

        upcomingPostsListResponse =  upcomingPostsListDomainToProvider.convert(upcomingPostsListDomainResponse);

        return upcomingPostsListResponse;

    }



}
