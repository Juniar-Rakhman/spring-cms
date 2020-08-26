package com.rcs.spring.cms.domain.requests;

import com.rcs.spring.cms.domain.entities.Role;
import lombok.Data;

@Data
public class UserRequest {

    String identity;

    String name;

    Role role;

}
