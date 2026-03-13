package org.jfcmc.springboot.scheta;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SchedulingTaskApplicationTests {

    @Autowired
    ScheduledTasks tasks;

    @Test
    void contextLoads() {
	assertThat(tasks).isNotNull();
    }
}
