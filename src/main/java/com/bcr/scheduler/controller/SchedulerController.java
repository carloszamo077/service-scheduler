
package com.bcr.scheduler.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SchedulerController {

	@RequestMapping(value = "/monitor", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> monitor() {

		String host = getHostName();

		return ResponseEntity.ok("MONITOR OK HOST: " + host);
	}

	private String getHostName() {
		return System.getenv().getOrDefault("HOSTNAME", "Unknown");
	}
}
