package org.jfcmc.springboot.scheta;

import org.awaitility.Durations;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class ScheduledTasksTest {

    // @SpyBean
    // ScheduledTasks tasks;
    @MockitoSpyBean
    ScheduledTasks tasks;

    @Test
    public void reportCurrentTime() {
	await().atMost(Durations.TEN_SECONDS).untilAsserted(() -> {
		verify(tasks, atLeast(2)).reportCurrentTime();
	    });
    }
}
