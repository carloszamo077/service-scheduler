
package com.bcr.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;

@SpringBootApplication
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "5m")
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class);
	}

}
