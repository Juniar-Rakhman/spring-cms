package com.rcs.spring.cms.domain.requests;

import com.rcs.spring.cms.domain.entities.Role;
import lombok.Data;

/**
 * @author claudioed on 29/10/17. Project cms
 */
@Data
public class UserRequest {

    String identity;

    String name;

    Role role;

}
