package bank.service.account.dto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import bank.service.account.domain.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDTO {

  private String cpf;
  private String name;
  @JsonProperty("printed_name")
  private String printedName;
  @JsonProperty("prefered_name")
  private String preferedName;
  private String email;
  private String phone;
  private String nationality;
  @JsonProperty("marital_status")
  private String maritalStatus;
  private String dog;
  private String profession;
  private String gender;
  @JsonProperty("address_line1")
  private String addressline1;
  @JsonProperty("address_line2")
  private String addressline2;
  @JsonProperty("address_state")
  private String addressState;
  @JsonProperty("address_number")
  private String addressNumber;
  @JsonProperty("address_postcode")
  private String addressPostcode;
  @JsonProperty("address_city")
  private String addressCity;
  @JsonProperty("address_country")
  private String addressCountry;
  @JsonProperty("address_locality")
  private String addressLocality;
  @JsonProperty("address_updated_at")
  private LocalDateTime addressUpdatedAt;
  @JsonProperty("billing_address_line1")
  private String billingAddressLine1;
  @JsonProperty("billing_address_line2")
  private String billingAddressLine2;
  @JsonProperty("billing_address_state")
  private String billingAddressState;
  @JsonProperty("billing_address_city")
  private String billingAddressCity;
  @JsonProperty("billing_address_localy")
  private String billingAddressLocaly;
  @JsonProperty("billing_address_postcode")
  private String billingAddressPostCode;
  @JsonProperty("billing_address_contry")
  private String billingAddressContry;
  @JsonProperty("billing_address_number")
  private String billingAddressNumber;
  private List<CustomerDocumentDTO> documents;
  @JsonProperty("primary_device")
  private CustomerDeviceDTO primaryDevice;
  private List<CustomerDeviceDTO> devices;
  private List<String> channels;
  @JsonProperty("external_ids")
  private HashMap<String, String> externalIds;
  @JsonProperty("last_atualizacao_cadastral_at")
  private String lastAtualizacaoCadastralAt;
  @JsonProperty("reported_income")
  private String reportedIncome;
  @JsonProperty("mothers_name")
  private String mothersName;
  private Integer invitations;

  @Deprecated
  public CustomerDTO() {

  }

  public CustomerDTO(String cpf, String name, String printedName, String preferedName, String email,
      String phone, String nationality, String maritalStatus, String dog, String profession, String gender,
      String addressline1, String addressline2, String addressState, String addressNumber, String addressPostcode,
      String addressCity, String addressCountry, String addressLocality, LocalDateTime addressUpdatedAt,
      String billingAddressLine1, String billingAddressLine2, String billingAddressState, String billingAddressCity,
      String billingAddressLocaly, String billingAddressPostCode, String billingAddressContry,
      String billingAddressNumber, List<CustomerDocumentDTO> documents, CustomerDeviceDTO primaryDevice,
      List<CustomerDeviceDTO> devices, List<String> channels, HashMap<String, String> externalIds,
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

  public List<CustomerDocumentDTO> getDocuments() {
    return documents;
  }

  public void setDocuments(List<CustomerDocumentDTO> documents) {
    this.documents = documents;
  }

  public CustomerDeviceDTO getPrimaryDevice() {
    return primaryDevice;
  }

  public void setPrimaryDevice(CustomerDeviceDTO primaryDevice) {
    this.primaryDevice = primaryDevice;
  }

  public List<CustomerDeviceDTO> getDevices() {
    return devices;
  }

  public void setDevices(List<CustomerDeviceDTO> devices) {
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

  public Customer toEntity() {
    return new Customer(getCpf(), getName(), getPrintedName(), getPreferedName(), getEmail(), getPhone(),
        getNationality(), getMaritalStatus(), getDog(), getProfession(), getGender(), getAddressline1(),
        getAddressline2(), getAddressState(), getAddressNumber(), getAddressPostcode(), getAddressCity(),
        getAddressCountry(), getAddressLocality(), getAddressUpdatedAt(), getBillingAddressLine1(),
        getBillingAddressLine2(), getBillingAddressState(), getBillingAddressCity(), getBillingAddressLocaly(),
        getBillingAddressPostCode(),
        getBillingAddressContry(), getBillingAddressNumber(),
        getDocuments().stream().map(CustomerDocumentDTO::toEntity).collect(Collectors.toList()),
        getPrimaryDevice().toEntity(),
        getDevices().stream().map(CustomerDeviceDTO::toEntity).collect(Collectors.toList()),
        getChannels(), getExternalIds(), getLastAtualizacaoCadastralAt(), getReportedIncome(), getMothersName(),
        getInvitations());
  }
}
