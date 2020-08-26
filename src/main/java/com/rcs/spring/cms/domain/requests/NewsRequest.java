package com.rcs.spring.cms.domain.requests;

import com.rcs.spring.cms.domain.entities.Category;
import com.rcs.spring.cms.domain.entities.Tag;
import lombok.Data;

import java.util.Set;

@Data
public class NewsRequest {

    String title;

    String content;

    Set<Category> categories;

    Set<Tag> tags;

}
