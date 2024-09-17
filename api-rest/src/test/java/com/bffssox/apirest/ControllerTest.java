package com.bffssox.apirest;


import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ControllerTest {


    @TestConfiguration
    static class TestContextConfiguration {
        @Bean
        public Controller controller() {
            return new Controller();
        }
    }

    @Autowired
    private Controller controller;

    @Test
    void givenAAndB_whenSumm_thenSumm() {
        int a = 1;
        int b = 2;

        Integer actual = controller.summ(a, b);

        assertThat(actual).isEqualTo(3);
    }
}