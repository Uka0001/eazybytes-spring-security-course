package com.cryptos.springsecsection11.repository;

import com.cryptos.springsecsection11.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, String> {


}
