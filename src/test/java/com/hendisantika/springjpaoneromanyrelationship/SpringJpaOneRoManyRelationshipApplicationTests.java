package com.hendisantika.springjpaoneromanyrelationship;

import com.hendisantika.springjpaoneromanyrelationship.repository.CompanyRepository;
import com.hendisantika.springjpaoneromanyrelationship.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Testcontainers
@SpringBootTest(
        properties = {
                "management.endpoint.health.show-details=always",
                "spring.datasource.url=jdbc:tc:mysql:9.1.0:///one_to_many"
        },
        webEnvironment = RANDOM_PORT
)
public class SpringJpaOneRoManyRelationshipApplicationTests {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void deleteAll() {
        companyRepository.deleteAll();
        productRepository.deleteAll();
    }
}
