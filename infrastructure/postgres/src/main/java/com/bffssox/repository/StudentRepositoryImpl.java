package com.bffssox.repository;

import com.bffssox.jpa.StudentJPA;
import com.bffssox.usecases.StudentRepository;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private StudentJPA studentJPA;

    public StudentRepositoryImpl(StudentJPA studentJPA) {
        this.studentJPA = studentJPA;
    }

    @Override
    public String execute(Long id) {
        return studentJPA.getReferenceById(id).getName();
    }
}
