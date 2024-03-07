package com.example.furama2.customer;

import java.util.Date;

public class Customer {
    private int id;
    private int customerTypeId;
    private String type;
    private String customerName;
    private String customerBirthday;
    private String customerGender;
    private String customerIdCard;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
    private String nameServiceAttach;
    private CategoryCustomer customer;

    public Customer(int id,int customerTypeId, String customerName, String customerBirthday, String customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress,CategoryCustomer customer) {
        this.id = id;
        this.customerTypeId = customerTypeId;

        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customer = customer;
    }

    public Customer(int id, int customerTypeId, String customerName, String customerBirthday, String customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, String nameServiceAttach, CategoryCustomer customer) {
        this.id = id;
        this.customerTypeId = customerTypeId;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.nameServiceAttach = nameServiceAttach;
        this.customer = customer;
    }

    public CategoryCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(CategoryCustomer customer) {
        this.customer = customer;
    }

    public Customer(int customerTypeId, String type, String customerName, String customerBirthday, String customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, String nameServiceAttach) {
        this.customerTypeId = customerTypeId;
        this.type = type;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.nameServiceAttach = nameServiceAttach;
    }

    public Customer(int id, int customerTypeId, String type, String customerName, String customerBirthday, String customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, String nameServiceAttach) {
        this.id = id;
        this.customerTypeId = customerTypeId;
        this.type = type;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.nameServiceAttach = nameServiceAttach;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNameServiceAttach() {
        return nameServiceAttach;
    }

    public void setNameServiceAttach(String nameServiceAttach) {
        this.nameServiceAttach = nameServiceAttach;
    }

    public Customer(int id, String customerName, String nameServiceAttach) {
        this.id = id;
        this.customerName = customerName;
        this.nameServiceAttach = nameServiceAttach;
    }

    public Customer() {
    }

    public Customer(int id, int customerTypeId, String customerName, String customerBirthday, String customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress) {
        this.id = id;
        this.customerTypeId = customerTypeId;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public Customer(int customerTypeId, String customerName, String customerBirthday, String customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress) {
        this.customerTypeId = customerTypeId;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
