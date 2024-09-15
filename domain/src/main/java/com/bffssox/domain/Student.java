package com.bffssox.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {

    private Long id;
    private String name;
    private String second_name;
    private Integer age;
    private Integer course;

}
