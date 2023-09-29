/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author djlap
 */
public class Medecine {
    private String id;
    private String names;
    private String company;
    private String quantity;
    private String price;
    private String username;

    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }

    public String getMandate() {
        return mandate;
    }

    public void setMandate(String mandate) {
        this.mandate = mandate;
    }

    public Medecine(String mandate, String expdate) {
        this.mandate = mandate;
        this.expdate = expdate;
    }
    private String mandate;
    private String expdate;

    public Medecine() {
    }

    public Medecine(String id, String names, String company, String quantity, String price, String username) {
        this.id = id;
        this.names = names;
        this.company = company;
        this.quantity = quantity;
        this.price = price;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   
    
}
