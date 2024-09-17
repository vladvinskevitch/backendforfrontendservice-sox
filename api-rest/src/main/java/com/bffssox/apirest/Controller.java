package com.bffssox.apirest;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    Integer summ(int a, int b) {
        return a + b;
    }
}
