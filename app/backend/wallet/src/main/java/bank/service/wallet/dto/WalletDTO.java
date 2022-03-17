package bank.service.wallet.dto;

import bank.service.wallet.domain.Wallet;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class WalletDTO {

    @JsonProperty("_id")
    private String id;

    private String name;
    private String cdi;
    private Double cdiPercentage;
    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonProperty("due_date")
    private Date dueDate;
    private Double value;

    public WalletDTO() {
    }

    public WalletDTO(Wallet domain) {
        this.id = domain.getId();
        this.cdiPercentage = domain.getCdi();
        this.dueDate = domain.getDueDate();
        this.name = domain.getName();
        this.value = domain.getValue();
    }

    public Wallet toEntity(){
        var domain = new Wallet();
        domain.setId(id);
        domain.setName(name);
        domain.setCdi(cdiPercentage);
        domain.setDueDate(dueDate);
        domain.setValue(value);
        return domain;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCdi() {
        return cdi;
    }

    public void setCdi(String cdi) {
        this.cdi = cdi;
    }

    public Double getCdiPercentage() {
        return cdiPercentage;
    }

    public void setCdiPercentage(Double cdiPercentage) {
        this.cdiPercentage = cdiPercentage;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
