package com.hendisantika.springjpaoneromanyrelationship;

import com.hendisantika.springjpaoneromanyrelationship.entity.Company;
import com.hendisantika.springjpaoneromanyrelationship.entity.Product;
import com.hendisantika.springjpaoneromanyrelationship.repository.CompanyRepository;
import com.hendisantika.springjpaoneromanyrelationship.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class SpringJpaOneRoManyRelationshipApplication implements CommandLineRunner {

    private static Logger logger = LogManager.getLogger(SpringJpaOneRoManyRelationshipApplication.class);

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(SpringJpaOneRoManyRelationshipApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        clearData();
        saveData();
        showData();
    }

    @Transactional
    void clearData() {
        companyRepository.deleteAll();
        productRepository.deleteAll();
    }

    @Transactional
    void saveData() {
        saveDataWithApproach1();
        // saveDataWithApproach2();
    }

    /**
     * Save Company objects that include Product list
     */
    private void saveDataWithApproach1() {
        Company apple = new Company("Apple");
        Company samsung = new Company("Samsung");

        Product iphone7 = new Product("Iphone 7", apple);
        Product iPadPro = new Product("IPadPro", apple);

        Product galaxyJ7 = new Product("GalaxyJ7", samsung);
        Product galaxyTabA = new Product("GalaxyTabA", samsung);

        apple.setProducts(new HashSet<Product>() {{
            add(iphone7);
            add(iPadPro);
        }});

        samsung.setProducts(new HashSet<Product>() {{
            add(galaxyJ7);
            add(galaxyTabA);
        }});

        // save companies
        companyRepository.save(apple);
        companyRepository.save(samsung);
    }


    /**
     * Save company first (not include product list). Then saving products which had attached a company for each.
     */
    private void saveDataWithApproach2() {

        /*
         * Firstly persist companies (not include product list)
         */
        Company apple = new Company("Apple");
        Company samsung = new Company("Samsung");

        //save companies
        companyRepository.save(apple);
        companyRepository.save(samsung);

        /*
         * Then store products with had persisted companies.
         */
        Product iphone7 = new Product("Iphone 7", apple);
        Product iPadPro = new Product("IPadPro", apple);

        Product galaxyJ7 = new Product("GalaxyJ7", samsung);
        Product galaxyTabA = new Product("GalaxyTabA", samsung);

        // save products
        productRepository.save(iphone7);
        productRepository.save(iPadPro);

        productRepository.save(galaxyJ7);
        productRepository.save(galaxyTabA);
    }

    @Transactional
    void showData() {
        // get All data
        List<Company> companyLst = companyRepository.findAll();
        List<Product> productLst = productRepository.findAll();

        logger.info("===================Product List:==================");
        productLst.forEach(System.out::println);

        logger.info("===================Company List:==================");
        companyLst.forEach(System.out::println);
    }


}
