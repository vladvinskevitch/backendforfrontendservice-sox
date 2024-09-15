package com.bffssox;

import com.bffssox.usecases.StudentController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private StudentController studentController;

    public Controller(StudentController studentController) {
        this.studentController = studentController;
    }

    @GetMapping("/student")
    public void getStudent() {
        final Long id = 2L;
        System.out.println(studentController.execute(id));
    }
}
