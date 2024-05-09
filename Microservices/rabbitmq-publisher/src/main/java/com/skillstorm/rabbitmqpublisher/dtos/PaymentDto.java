package com.skillstorm.rabbitmqpublisher.dtos;

public class PaymentDto {

    /*
     * DTOs are very common in microservices
     *      each service can use the same data in different ways 
     *      with a DTO, there's an agreed upon way for the data to look when it is sent around
     * 
     *      one service might use it for orders (products, purchase date, along with user and amount)
     *      another service accounts (username, passwords, emails, along with amount)
     */

    private String username;
    private double amount;

    public PaymentDto() {
    }

    public PaymentDto(String username, double amount) {
        this.username = username;
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentDto [username=" + username + ", amount=" + amount + "]";
    }
}
