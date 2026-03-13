package org.jfcmc.springboot.scheta;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.awaitility.Durations;

import static org.awaitility.Awaitility.await;

@SpringBootTest
class SchedulingTaskApplicationTests {

    // @SpyBean
    @MockitoSpyBean
    ScheduledTasks tasks;

    @Test
    void contextLoads() {
    }

    // @Test
    // public void reportCurrentTime() {
    // 	await().atMost(Durations.TEN_SECONDS).untilAsserted(() -> {
    // 		verify(tasks, atLeast(2)).reportCurrentTime();
    // 	    });
    // }
}
