
package com.bcr.scheduler.autorizaciones;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.javacrumbs.shedlock.core.LockAssert;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;

@PropertySource("classpath:application.properties")
@Component
public class AutEnvioRun {

	private static final Logger LOGGER = LoggerFactory.getLogger(AutEnvioRun.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	@Value("${app.codigo}")
	private String appCodigo;

	@Value("${app.db.divisibilidad}")
	private String divisibilidad;

	@Value("${app.db.fetch.size}")
	private int fetchSize;

	@Value("${app.api.envio}")
	private String apiEnvioAutorizaciones;

	@Value("${app.timeout}")
	private int timeout;

	@Value("${app.fixed.delay.envio}")
	private int fixedDelayEnvioAut;

	@Value("${app.fixed.delay.reenvio}")
	private int fixedDelayReenvioAut;

	@Value("${app.db.max.dias}")
	private int maxDias;

	public AutEnvioRun() {
	}

	@Scheduled(fixedDelayString = "${app.fixed.delay.envio}")
	@SchedulerLock(name = "ENVIOS_LOCK", lockAtLeastFor = "2s", lockAtMostFor = "1m")
	public void scheduledTask() throws InterruptedException {
		LockAssert.assertLocked();
		System.out.println("----->ENVIOS: " + new Date());

		for (int i = 1; i <= 15; i++) {
			System.out.println("ENVIOS: " + i);
			Thread.sleep(1000);
		}
		System.out.println("----->FIN ENVIOS: " + new Date());
	}

	@Scheduled(fixedDelayString = "2000")
	@SchedulerLock(name = "REENVIOS_LOCK", lockAtLeastFor = "2s", lockAtMostFor = "1m")
	public void scheduledTask1() throws InterruptedException {
		LockAssert.assertLocked();
		System.out.println("xxxxx>REENVIOS: " + new Date());
		for (int i = 1; i <= 12; i++) {
			System.out.println("REENVIOS: " + i);
			Thread.sleep(1000);
		}
		System.out.println("xxxxx>FIN REENVIOS: " + new Date());
	}

	@Scheduled(fixedDelayString = "2000")
	@SchedulerLock(name = "EST_CNTA_LOCK", lockAtLeastFor = "2s", lockAtMostFor = "1m")
	public void scheduledTask2() throws InterruptedException {
		LockAssert.assertLocked();
		System.out.println("xxxxx>EST_CUENTA: " + new Date());
		for (int i = 1; i <= 12; i++) {
			System.out.println("EST_CUENTA: " + i);
			Thread.sleep(1000);
		}
		System.out.println("xxxxx>FIN EST_CUENTA: " + new Date());
	}

}
