package com.rcs.spring.cms.domain.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "users")
public class User {

    @Id
    String id;

    String identity;

    String name;

    Role role;
}
