package com.hendisantika.springjpaoneromanyrelationship.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Set;

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
@Table(name="company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Product> products;

    public Company(){
    }

    public Company(String name){
        this.name = name;
    }

    // name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // products
    public void setProducts(Set<Product> products){
        this.products = products;
    }

    public Set<Product> getProducts(){
        return this.products;
    }

    public String toString(){
        String info = "";
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("name",this.name);

        JSONArray productArray = new JSONArray();
        if(this.products != null){
            this.products.forEach(product->{
                JSONObject subJson = new JSONObject();
                subJson.put("name", product.getName());
                productArray.put(subJson);
            });
        }
        jsonInfo.put("products", productArray);
        info = jsonInfo.toString();
        return info;
    }
}
