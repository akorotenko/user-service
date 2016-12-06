package com.bigpay.microservices.users.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by akorotenko on 12/5/16.
 */
@Entity(name = "Users")
public class User implements Serializable {

//    /**
//     * Echoed back from the request
//     */
//    @Column(name = "TxnRefNo", length = 12)
//    private String txnRefNo;
//
//    /**
//     * Echoed back from the request.
//     */
//    @Column(name = "CardNumber", length = 5)
//    private String cardNumber;

    @Id
    @Column(name = "UserName", nullable = false, length = 8)
    private String userName;

    // Transactions/CustomerInfo

    /**
     * Customer’s Title
     */
    @Column(name = "Title", length = 5)
    private String title;

    /**
     * Customer’s First Name
     */
    @Column(name = "FirstName", length = 25)
    private String firstName;

    /**
     * Customer’s Last Name
     */
    @Column(name = "LastName", length = 25)
    private String lastName;

    /**
     * Customer’s Date of Birth. Format : DDMMYYYY
     */
    @Column(name = "DOB", length = 12)
    private String DOB;

    /**
     * Customer’s Gender [M/F]
     */
    @Column(name = "Gender", length = 1)
    private String gender;

    /**
     * Customer’s Mobile Number
     */
    @Column(name = "MobileNumber", length = 15)
    private String mobileNumber;

    /**
     * Customer’s Email Address
     */
    @Column(name = "EmailAddress", length = 50)
    private String emailAddress;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Card> cards;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }
}
