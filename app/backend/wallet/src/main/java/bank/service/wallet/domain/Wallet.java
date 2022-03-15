package bank.service.wallet.domain;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "wallets")
public class Wallet {
    @BsonId
    private String id;

    private String name;
    private Double cdi;
    private Date dueDate;
    private Double value;

    public Wallet() {
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

    public Double getCdi() {
        return cdi;
    }

    public void setCdi(Double cdi) {
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
