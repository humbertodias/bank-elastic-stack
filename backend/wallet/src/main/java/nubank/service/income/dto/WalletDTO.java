package nubank.service.income.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import nubank.service.income.domain.Wallet;

public class WalletDTO {

    @JsonProperty("_id")
    private String id;

    private String name;
    private String cdi;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonProperty("due_date")
    private Date dueDate;
    private Double value;

    public WalletDTO() {
    }

    public WalletDTO(Wallet domain) {
        this.id = domain.getId();
        this.cdi = domain.getCdi();
        this.dueDate = domain.getDueDate();
        this.name = domain.getName();
        this.value = domain.getValue();
    }

    public Wallet toEntity(){
        var domain = new Wallet();
        domain.setId(id);
        domain.setCdi(cdi);
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
