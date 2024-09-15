package com.bffssox.usecase;

import com.bffssox.usecases.StudentController;
import com.bffssox.usecases.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentControllerImpl implements StudentController {

    private StudentRepository studentRepository;

    public StudentControllerImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public String execute(Long id) {
        return studentRepository.execute(id);
    }
}
