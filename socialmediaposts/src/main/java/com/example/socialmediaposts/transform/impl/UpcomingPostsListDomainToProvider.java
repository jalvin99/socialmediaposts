package com.med.demo.transform.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class PostDomainToProvider extends AbstractDomainToProvider<upcomingPostsListDomainResponse, upcomingPostsListResponse> {

    @Autowired
    private UpcomingPostsListMapper upcomingPostsListMapper;

    public UpcomingPostListResponse convert(UpcomingPostsListMapper domainResponse){
        UpcomingPostListResponse providerResponse = new UpcomingPostListResponse();

    }

}