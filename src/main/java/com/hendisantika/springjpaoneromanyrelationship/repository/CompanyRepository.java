package com.hendisantika.springjpaoneromanyrelationship.repository;

import com.hendisantika.springjpaoneromanyrelationship.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-jpa-one-ro-many-relationship
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-13
 * Time: 06:30
 */
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
