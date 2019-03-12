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
