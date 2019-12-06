package com.rcs.spring.cms.domain.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Category {

    @Id
    @GeneratedValue(generator = "system-uuid") //use randomize uuid
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    String id;

    String name;
}
