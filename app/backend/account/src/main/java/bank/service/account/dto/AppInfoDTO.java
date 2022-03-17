package bank.service.account.dto;

public class AppInfoDTO {

	private final String appName;
	private final String hostName;
	private final String os;

	public AppInfoDTO(String appName, String hostName, String os) {
		this.appName = appName;
		this.hostName = hostName;
		this.os = os;
	}

	public String getAppName() { return appName;}
	public String getHostName() { return hostName;}
	public String getOs() { return os;}

}
