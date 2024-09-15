package com.bffssox.jpa;

import com.bffssox.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJPA  extends JpaRepository<StudentEntity, Long> {
}
