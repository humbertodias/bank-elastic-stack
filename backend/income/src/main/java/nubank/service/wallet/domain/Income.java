package nubank.service.wallet.domain;


import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "incomes")
public class Income {
    @BsonId
    private String id;

    private String name;
    private Double cdiPercentage;
    private Date dueDate;

    public Income() {
    }

    public Income(String name, Double cdiPercentage, Date dueDate) {
        this.name = name;
        this.cdiPercentage = cdiPercentage;
        this.dueDate = dueDate;
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
