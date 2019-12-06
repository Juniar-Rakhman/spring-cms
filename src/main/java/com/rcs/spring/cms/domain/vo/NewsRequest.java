package com.rcs.spring.cms.domain.vo;

import com.rcs.spring.cms.domain.models.Category;
import com.rcs.spring.cms.domain.models.Tag;
import lombok.Data;

import java.util.Set;

/**
 * @author claudioed on 29/10/17. Project cms
 */
@Data
public class NewsRequest {

    String title;

    String content;

    Set<Category> categories;

    Set<Tag> tags;

}
