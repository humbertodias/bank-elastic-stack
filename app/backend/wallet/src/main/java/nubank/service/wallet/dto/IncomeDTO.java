package nubank.service.wallet.dto;

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
