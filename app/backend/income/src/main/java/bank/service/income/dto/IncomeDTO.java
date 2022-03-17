package bank.service.income.dto;

import bank.service.income.domain.Income;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class IncomeDTO {

    @JsonProperty("_id")
    private String id;
    private String name;
    @JsonProperty("cdi_percentage")
    private Double cdiPercentage;

    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonProperty("due_date")
    private Date dueDate;

    public IncomeDTO() {
    }

    public IncomeDTO(Income domain) {
        this.id = domain.getId();
        this.name = domain.getName();
        this.dueDate = domain.getDueDate();
        this.cdiPercentage = domain.getCdiPercentage();
    }

    public Income toEntity(){
        var domain = new Income();
        domain.setId(id);
        domain.setName(name);
        domain.setCdiPercentage(cdiPercentage);
        domain.setDueDate(dueDate);
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
}
