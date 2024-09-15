package com.bffssox.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "STUDENT")
@NoArgsConstructor
@AllArgsConstructor

public class StudentEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SECOND_NAME")
    private String second_name;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "COURSE")
    private Integer course;

}
