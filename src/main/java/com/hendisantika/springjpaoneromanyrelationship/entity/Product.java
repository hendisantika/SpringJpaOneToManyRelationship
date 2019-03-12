package com.hendisantika.springjpaoneromanyrelationship.entity;

import org.json.JSONObject;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-jpa-one-ro-many-relationship
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-13
 * Time: 06:27
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    public Product() {
    }

    public Product(String name, Company company) {
        this.name = name;
        this.company = company;
    }

    // name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return this.company;
    }

    // products
    public void setCompany(Company company) {
        this.company = company;
    }

    public String toString() {
        String info = "";

        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("name", this.name);

        JSONObject companyObj = new JSONObject();
        companyObj.put("name", this.company.getName());
        jsonInfo.put("company", companyObj);

        info = jsonInfo.toString();
        return info;
    }
}