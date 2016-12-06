package com.bigpay.microservices.users.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by akorotenko on 12/5/16.
 */
@Entity
public class Card implements Serializable {

    public Card() {
    }

    public Card(String cardNumber, String cardStatus, String amount, String productCode, String currency) {
        this.cardNumber = cardNumber;
        this.cardStatus = cardStatus;
        this.amount = amount;
        ProductCode = productCode;
        Currency = currency;
    }

    /**
     * List of linked card number with the given card number
     */
    @Id
//    @Column(length = 16, nullable = false)
    private String cardNumber;

    /**
     * Status of the Card
     */
    @Column(name = "cardStatus", nullable = false, length = 50)
    private String cardStatus;


    /**
     * Balance of the wallet
     */
    @Column(name = "Amount", length = 12)
    private String amount;

    /**
     * Product code of the Wallet
     */
    @Column(name = "ProductCode", length = 6)
    private String ProductCode;


    /**
     * ISO Currency code of the Balance Amount
     */
    @Column(name = "Currency", length = 3)
    private String Currency;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String productCode) {
        ProductCode = productCode;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }
}
