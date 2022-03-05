package nubank.service.account.controller;

import nubank.service.account.dto.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
public class InfoController {
	
	@GetMapping("/")
	public String home() {
		return "Java Spring Boot application is up and running";
	}
	
	@GetMapping("/account/info")
	public AppInfoDTO status() {
		// obtain a hostname. First try to get the host name from docker container (from the "HOSTNAME" environment variable)
		String hostName = System.getenv("HOSTNAME");

		// get the os name
		String os = System.getProperty("os.name");

		// if the application is not running in a docker container, we can to obtain the hostname using the "java.net.InetAddress" class
		if(hostName == null || hostName.isEmpty()) {
			try {
				InetAddress addr = InetAddress.getLocalHost();
				hostName = addr.getHostName();
			} catch (Exception e) {
				System.err.println(e);
				hostName = "Unknow";
			}
		}
		return new AppInfoDTO("Sample Java Spring Boot app", hostName, os);
	}
}