package com.rcs.spring.cms.domain.vo;

import com.rcs.spring.cms.domain.models.Role;
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
