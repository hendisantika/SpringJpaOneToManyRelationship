# SpringJpaOneToManyRelationship

This tutorial will guide you through the steps of configuring Spring JPA One to Many relationship with Spring Boot and MySQL.

* __@Entity__: Specifies that the class is an entity. This annotation is applied to the entity class.
* __@Id__: Specifies the primary key of an entity.
* __@OneToMany__: Defines a many-valued association with one-to-many multiplicity.
* __@ManyToOne__: Defines a single-valued association to another entity class that has many-to-one multiplicity
* __@JoinColumn__: Specifies a column for joining an entity association or element collection. If the JoinColumn annotation itself is defaulted, a single join column is assumed and the default values apply.


Implement 3 functions:
– `clearData()` is used to empty 2 tables __company__ & __product__
– `saveData()` is used to persist entities (__Company__ & __Product__) to database
– `showData()` is used to load all records (__Company__ & __Product__) and show all on console.

For `saveData()`, we have to 2 approach:
-> `saveDataWithApproach1()`: saving `Company` objects that include `Product` list.
-> `saveDataWithApproach2()`: firstly persist `Company` entities(not include `Product` list). Then store `Products` with the persisted companies.

## Run & Check results

Build & Run the project with __SpringBoot App__ mode.

– With __Approach 1__ for saving:
-> __Hibernate Logs__:
```
Hibernate: select company0_.id as id1_0_, company0_.name as name2_0_ from company company0_
Hibernate: select products0_.company_id as company_3_1_0_, products0_.id as id1_1_0_, products0_.id as id1_1_1_, products0_.company_id as company_3_1_1_, products0_.name as name2_1_1_ from product products0_ where products0_.company_id=?
Hibernate: select products0_.company_id as company_3_1_0_, products0_.id as id1_1_0_, products0_.id as id1_1_1_, products0_.company_id as company_3_1_1_, products0_.name as name2_1_1_ from product products0_ where products0_.company_id=?
Hibernate: delete from product where id=?
Hibernate: delete from product where id=?
Hibernate: delete from company where id=?
Hibernate: delete from product where id=?
Hibernate: delete from product where id=?
Hibernate: delete from company where id=?
Hibernate: select product0_.id as id1_1_, product0_.company_id as company_3_1_, product0_.name as name2_1_ from product product0_
Hibernate: insert into company (name) values (?)
Hibernate: insert into product (company_id, name) values (?, ?)
Hibernate: insert into product (company_id, name) values (?, ?)
Hibernate: insert into company (name) values (?)
Hibernate: insert into product (company_id, name) values (?, ?)
Hibernate: insert into product (company_id, name) values (?, ?)
Hibernate: select company0_.id as id1_0_, company0_.name as name2_0_ from company company0_
Hibernate: select products0_.company_id as company_3_1_0_, products0_.id as id1_1_0_, products0_.id as id1_1_1_, products0_.company_id as company_3_1_1_, products0_.name as name2_1_1_ from product products0_ where products0_.company_id=?
Hibernate: select products0_.company_id as company_3_1_0_, products0_.id as id1_1_0_, products0_.id as id1_1_1_, products0_.company_id as company_3_1_1_, products0_.name as name2_1_1_ from product products0_ where products0_.company_id=?
Hibernate: select product0_.id as id1_1_, product0_.company_id as company_3_1_, product0_.name as name2_1_ from product product0_
Hibernate: select company0_.id as id1_0_0_, company0_.name as name2_0_0_, products1_.company_id as company_3_1_1_, products1_.id as id1_1_1_, products1_.id as id1_1_2_, products1_.company_id as company_3_1_2_, products1_.name as name2_1_2_ from company company0_ left outer join product products1_ on company0_.id=products1_.company_id where company0_.id=?
Hibernate: select company0_.id as id1_0_0_, company0_.name as name2_0_0_, products1_.company_id as company_3_1_1_, products1_.id as id1_1_1_, products1_.id as id1_1_2_, products1_.company_id as company_3_1_2_, products1_.name as name2_1_2_ from company company0_ left outer join product products1_ on company0_.id=products1_.company_id where company0_.id=?
```

– With __Approach 2__ for saving:
-> __Hibernate Logs__:
```
Hibernate: select company0_.id as id1_0_, company0_.name as name2_0_ from company company0_
Hibernate: select products0_.company_id as company_3_1_0_, products0_.id as id1_1_0_, products0_.id as id1_1_1_, products0_.company_id as company_3_1_1_, products0_.name as name2_1_1_ from product products0_ where products0_.company_id=?
Hibernate: select products0_.company_id as company_3_1_0_, products0_.id as id1_1_0_, products0_.id as id1_1_1_, products0_.company_id as company_3_1_1_, products0_.name as name2_1_1_ from product products0_ where products0_.company_id=?
Hibernate: delete from product where id=?
Hibernate: delete from product where id=?
Hibernate: delete from company where id=?
Hibernate: delete from product where id=?
Hibernate: delete from product where id=?
Hibernate: delete from company where id=?
Hibernate: select product0_.id as id1_1_, product0_.company_id as company_3_1_, product0_.name as name2_1_ from product product0_
Hibernate: insert into company (name) values (?)
Hibernate: insert into company (name) values (?)
Hibernate: insert into product (company_id, name) values (?, ?)
Hibernate: insert into product (company_id, name) values (?, ?)
Hibernate: insert into product (company_id, name) values (?, ?)
Hibernate: insert into product (company_id, name) values (?, ?)
Hibernate: select company0_.id as id1_0_, company0_.name as name2_0_ from company company0_
Hibernate: select products0_.company_id as company_3_1_0_, products0_.id as id1_1_0_, products0_.id as id1_1_1_, products0_.company_id as company_3_1_1_, products0_.name as name2_1_1_ from product products0_ where products0_.company_id=?
Hibernate: select products0_.company_id as company_3_1_0_, products0_.id as id1_1_0_, products0_.id as id1_1_1_, products0_.company_id as company_3_1_1_, products0_.name as name2_1_1_ from product products0_ where products0_.company_id=?
Hibernate: select product0_.id as id1_1_, product0_.company_id as company_3_1_, product0_.name as name2_1_ from product product0_
Hibernate: select company0_.id as id1_0_0_, company0_.name as name2_0_0_, products1_.company_id as company_3_1_1_, products1_.id as id1_1_1_, products1_.id as id1_1_2_, products1_.company_id as company_3_1_2_, products1_.name as name2_1_2_ from company company0_ left outer join product products1_ on company0_.id=products1_.company_id where company0_.id=?
Hibernate: select company0_.id as id1_0_0_, company0_.name as name2_0_0_, products1_.company_id as company_3_1_1_, products1_.id as id1_1_1_, products1_.id as id1_1_2_, products1_.company_id as company_3_1_2_, products1_.name as name2_1_2_ from company company0_ left outer join product products1_ on company0_.id=products1_.company_id where company0_.id=?
```

-> __Application’s Logs:__
```
===================Product List:==================
{"name":"Iphone 7","company":{"name":"Apple"}}
{"name":"IPadPro","company":{"name":"Apple"}}
{"name":"GalaxyJ7","company":{"name":"Samsung"}}
{"name":"GalaxyTabA","company":{"name":"Samsung"}}
===================Company List:==================
{"name":"Apple","products":[{"name":"Iphone 7"},{"name":"IPadPro"}]}
{"name":"Samsung","products":[{"name":"GalaxyTabA"},{"name":"GalaxyJ7"}]}
```