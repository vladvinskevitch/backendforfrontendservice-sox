package com.bffssox.usecase;

import com.bffssox.usecases.StudentController;
import com.bffssox.usecases.StudentRepository;


public class StudentControllerImpl implements StudentController {

    private StudentRepository studentRepository;

    @Override
    public String execute(Long id) {
        return studentRepository.execute(id);
    }
}
