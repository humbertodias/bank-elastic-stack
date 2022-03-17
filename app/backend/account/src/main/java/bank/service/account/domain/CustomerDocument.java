package bank.service.account.domain;


import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "customer-document")
public class CustomerDocument {
    @BsonId
    private String id;

    private String type;
    private String number;
    private String issuer;

    public CustomerDocument() {
    }

    public CustomerDocument(String type, String number, String issuer) {
        this.type = type;
        this.number = number;
        this.issuer = issuer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
}
