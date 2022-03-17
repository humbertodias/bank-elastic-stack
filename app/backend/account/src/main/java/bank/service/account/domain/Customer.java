package bank.service.account.domain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import org.bson.codecs.pojo.annotations.BsonId;

public class Customer {

  @BsonId
  private String id;
  private String cpf;
  private String name;
  private String printedName;
  private String preferedName;
  private String email;
  private String phone;
  private String nationality;
  private String maritalStatus;
  private String dog;
  private String profession;
  private String gender;
  private String addressline1;
  private String addressline2;
  private String addressState;
  private String addressNumber;
  private String addressPostcode;
  private String addressCity;
  private String addressCountry;
  private String addressLocality;
  private LocalDateTime addressUpdatedAt;
  private String billingAddressLine1;
  private String billingAddressLine2;
  private String billingAddressState;
  private String billingAddressCity;
  private String billingAddressLocaly;
  private String billingAddressPostCode;
  private String billingAddressContry;
  private String billingAddressNumber;
  private List<CustomerDocument> documents;
  private CustomerDevice primaryDevice;
  private List<CustomerDevice> devices;
  private List<String> channels;
  private HashMap<String, String> externalIds;
  private String lastAtualizacaoCadastralAt;
  private String reportedIncome;
  private String mothersName;
  private Integer invitations;

  public Customer(String cpf, String name, String printedName, String preferedName, String email,
      String phone, String nationality, String maritalStatus, String dog, String profession, String gender,
      String addressline1, String addressline2, String addressState, String addressNumber, String addressPostcode,
      String addressCity, String addressCountry, String addressLocality, LocalDateTime addressUpdatedAt,
      String billingAddressLine1, String billingAddressLine2, String billingAddressState, String billingAddressCity,
      String billingAddressLocaly, String billingAddressPostCode, String billingAddressContry,
      String billingAddressNumber, List<CustomerDocument> documents, CustomerDevice primaryDevice,
      List<CustomerDevice> devices, List<String> channels, HashMap<String, String> externalIds,
      String lastAtualizacaoCadastralAt,
      String reportedIncome, String mothersName, Integer invitations) {
    this.cpf = cpf;
    this.name = name;
    this.printedName = printedName;
    this.preferedName = preferedName;
    this.email = email;
    this.phone = phone;
    this.nationality = nationality;
    this.maritalStatus = maritalStatus;
    this.dog = dog;
    this.profession = profession;
    this.gender = gender;
    this.addressline1 = addressline1;
    this.addressline2 = addressline2;
    this.addressState = addressState;
    this.addressNumber = addressNumber;
    this.addressPostcode = addressPostcode;
    this.addressCity = addressCity;
    this.addressCountry = addressCountry;
    this.addressLocality = addressLocality;
    this.addressUpdatedAt = addressUpdatedAt;
    this.billingAddressLine1 = billingAddressLine1;
    this.billingAddressLine2 = billingAddressLine2;
    this.billingAddressState = billingAddressState;
    this.billingAddressCity = billingAddressCity;
    this.billingAddressLocaly = billingAddressLocaly;
    this.billingAddressPostCode = billingAddressPostCode;
    this.billingAddressContry = billingAddressContry;
    this.billingAddressNumber = billingAddressNumber;
    this.documents = documents;
    this.primaryDevice = primaryDevice;
    this.devices = devices;
    this.channels = channels;
    this.externalIds = externalIds;
    this.lastAtualizacaoCadastralAt = lastAtualizacaoCadastralAt;
    this.reportedIncome = reportedIncome;
    this.mothersName = mothersName;
    this.invitations = invitations;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPrintedName() {
    return printedName;
  }

  public void setPrintedName(String printedName) {
    this.printedName = printedName;
  }

  public String getPreferedName() {
    return preferedName;
  }

  public void setPreferedName(String preferedName) {
    this.preferedName = preferedName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public String getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public String getDog() {
    return dog;
  }

  public void setDog(String dog) {
    this.dog = dog;
  }

  public String getProfession() {
    return profession;
  }

  public void setProfession(String profession) {
    this.profession = profession;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAddressline1() {
    return addressline1;
  }

  public void setAddressline1(String addressline1) {
    this.addressline1 = addressline1;
  }

  public String getAddressline2() {
    return addressline2;
  }

  public void setAddressline2(String addressline2) {
    this.addressline2 = addressline2;
  }

  public String getAddressState() {
    return addressState;
  }

  public void setAddressState(String addressState) {
    this.addressState = addressState;
  }

  public String getAddressNumber() {
    return addressNumber;
  }

  public void setAddressNumber(String addressNumber) {
    this.addressNumber = addressNumber;
  }

  public String getAddressPostcode() {
    return addressPostcode;
  }

  public void setAddressPostcode(String addressPostcode) {
    this.addressPostcode = addressPostcode;
  }

  public String getAddressCity() {
    return addressCity;
  }

  public void setAddressCity(String addressCity) {
    this.addressCity = addressCity;
  }

  public String getAddressCountry() {
    return addressCountry;
  }

  public void setAddressCountry(String addressCountry) {
    this.addressCountry = addressCountry;
  }

  public String getAddressLocality() {
    return addressLocality;
  }

  public void setAddressLocality(String addressLocality) {
    this.addressLocality = addressLocality;
  }

  public LocalDateTime getAddressUpdatedAt() {
    return addressUpdatedAt;
  }

  public void setAddressUpdatedAt(LocalDateTime addressUpdatedAt) {
    this.addressUpdatedAt = addressUpdatedAt;
  }

  public String getBillingAddressLine1() {
    return billingAddressLine1;
  }

  public void setBillingAddressLine1(String billingAddressLine1) {
    this.billingAddressLine1 = billingAddressLine1;
  }

  public String getBillingAddressLine2() {
    return billingAddressLine2;
  }

  public void setBillingAddressLine2(String billingAddressLine2) {
    this.billingAddressLine2 = billingAddressLine2;
  }

  public String getBillingAddressState() {
    return billingAddressState;
  }

  public void setBillingAddressState(String billingAddressState) {
    this.billingAddressState = billingAddressState;
  }

  public String getBillingAddressCity() {
    return billingAddressCity;
  }

  public void setBillingAddressCity(String billingAddressCity) {
    this.billingAddressCity = billingAddressCity;
  }

  public String getBillingAddressLocaly() {
    return billingAddressLocaly;
  }

  public void setBillingAddressLocaly(String billingAddressLocaly) {
    this.billingAddressLocaly = billingAddressLocaly;
  }

  public String getBillingAddressPostCode() {
    return billingAddressPostCode;
  }

  public void setBillingAddressPostCode(String billingAddressPostCode) {
    this.billingAddressPostCode = billingAddressPostCode;
  }

  public String getBillingAddressContry() {
    return billingAddressContry;
  }

  public void setBillingAddressContry(String billingAddressContry) {
    this.billingAddressContry = billingAddressContry;
  }

  public String getBillingAddressNumber() {
    return billingAddressNumber;
  }

  public void setBillingAddressNumber(String billingAddressNumber) {
    this.billingAddressNumber = billingAddressNumber;
  }

  public List<CustomerDocument> getDocuments() {
    return documents;
  }

  public void setDocuments(List<CustomerDocument> documents) {
    this.documents = documents;
  }

  public CustomerDevice getPrimaryDevice() {
    return primaryDevice;
  }

  public void setPrimaryDevice(CustomerDevice primaryDevice) {
    this.primaryDevice = primaryDevice;
  }

  public List<CustomerDevice> getDevices() {
    return devices;
  }

  public void setDevices(List<CustomerDevice> devices) {
    this.devices = devices;
  }

  public List<String> getChannels() {
    return channels;
  }

  public void setChannels(List<String> channels) {
    this.channels = channels;
  }

  public HashMap<String, String> getExternalIds() {
    return externalIds;
  }

  public void setExternalIds(HashMap<String, String> externalIds) {
    this.externalIds = externalIds;
  }

  public String getLastAtualizacaoCadastralAt() {
    return lastAtualizacaoCadastralAt;
  }

  public void setLastAtualizacaoCadastralAt(String lastAtualizacaoCadastralAt) {
    this.lastAtualizacaoCadastralAt = lastAtualizacaoCadastralAt;
  }

  public String getReportedIncome() {
    return reportedIncome;
  }

  public void setReportedIncome(String reportedIncome) {
    this.reportedIncome = reportedIncome;
  }

  public String getMothersName() {
    return mothersName;
  }

  public void setMothersName(String mothersName) {
    this.mothersName = mothersName;
  }

  public Integer getInvitations() {
    return invitations;
  }

  public void setInvitations(Integer invitations) {
    this.invitations = invitations;
  }

}
