package bank.service.account.dto;


import bank.service.account.domain.CustomerDocument;

public class CustomerDocumentDTO {
    private String id;

    private String type;
    private String number;
    private String issuer;

    public CustomerDocumentDTO() {
    }

    public CustomerDocumentDTO(CustomerDocument domain) {
        this.id = domain.getId();
        this.type = domain.getType();
        this.number = domain.getNumber();
        this.issuer = domain.getIssuer();
    }

    public CustomerDocument toEntity(){
        var domain = new CustomerDocument();
        domain.setId(id);
        domain.setType(type);
        domain.setNumber(number);
        domain.setIssuer(issuer);
        return domain;
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
