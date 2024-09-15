package com.bffssox.repository;

import com.bffssox.jpa.StudentJPA;
import com.bffssox.usecases.StudentRepository;

public class StudentRepositoryImpl implements StudentRepository {

    private StudentJPA studentJPA;

    @Override
    public String execute(Long id) {
        return studentJPA.getReferenceById(id).getName();
    }
}
