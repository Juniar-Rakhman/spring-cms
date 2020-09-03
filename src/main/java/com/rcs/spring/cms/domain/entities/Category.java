package com.rcs.spring.cms.domain.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "category")
public class Category {

    @Id
    String id;

    String name;

}
