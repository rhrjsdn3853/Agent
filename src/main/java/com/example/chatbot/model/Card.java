package com.example.chatbot.model;

public class Card {
    private String cardName;
    private String cardType;
    private String annualFee;
    private String details;
    private String url; // URL 필드 추가

    // 생성자 업데이트
    public Card(String cardName, String cardType, String annualFee, String details, String url) {
        this.cardName = cardName;
        this.cardType = cardType;
        this.annualFee = annualFee;
        this.details = details;
        this.url = url;
    }

    // Getters and Setters
    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(String annualFee) {
        this.annualFee = annualFee;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getUrl() { // URL Getter
        return url;
    }

    public void setUrl(String url) { // URL Setter
        this.url = url;
    }
}
