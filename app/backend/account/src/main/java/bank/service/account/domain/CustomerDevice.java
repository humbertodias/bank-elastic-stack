package bank.service.account.domain;

import org.bson.codecs.pojo.annotations.BsonId;

public class CustomerDevice {

  @BsonId
  private String id;
  private String deviceId;
  private String userAgent;
  private String pushToken;

  public CustomerDevice(String deviceId, String userAgent, String pushToken) {

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

}
