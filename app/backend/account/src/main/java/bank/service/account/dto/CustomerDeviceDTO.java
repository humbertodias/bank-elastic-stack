package bank.service.account.dto;

import bank.service.account.domain.CustomerDevice;

public class CustomerDeviceDTO {

  private String deviceId;
  private String userAgent;
  private String pushToken;

  @Deprecated
  public CustomerDeviceDTO() {
  }

  public CustomerDeviceDTO(String deviceId, String userAgent, String pushToken) {

    this.deviceId = deviceId;
    this.userAgent = userAgent;
    this.pushToken = pushToken;

  }

  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public String getUserAgent() {
    return userAgent;
  }

  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }

  public String getPushToken() {
    return pushToken;
  }

  public void setPushToken(String pushToken) {
    this.pushToken = pushToken;
  }

  public CustomerDevice toEntity() {
    return new CustomerDevice(getDeviceId(), getUserAgent(), getPushToken());
  }

}
