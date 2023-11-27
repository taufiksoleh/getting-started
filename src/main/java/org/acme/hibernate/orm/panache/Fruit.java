package org.acme.hibernate.orm.panache;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
@Cacheable
public class Fruit extends BaseEntity {

    @Column(length = 40, unique = true)
    public String name;

}