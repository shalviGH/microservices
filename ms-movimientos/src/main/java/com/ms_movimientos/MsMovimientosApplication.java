package com.ms_movimientos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsMovimientosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMovimientosApplication.class, args);
	}

}
