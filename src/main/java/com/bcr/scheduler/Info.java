
package com.bcr.scheduler;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;

@Component
public class Info {

	private static final Logger LOGGER = LoggerFactory.getLogger(Info.class);

	@EventListener(ApplicationReadyEvent.class)
	public void contextRefreshedEvent() {
		LOGGER.info("\n************************************" + "\nSCHEDULER INICIALIZADO CORRECTAMENTE"
				+ "\n************************************");
	}
}