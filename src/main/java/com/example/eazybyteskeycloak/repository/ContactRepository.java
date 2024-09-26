package com.example.eazybyteskeycloak.repository;

import com.example.eazybyteskeycloak.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, String> {
	
	
}
