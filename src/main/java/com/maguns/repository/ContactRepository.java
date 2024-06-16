package com.maguns.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maguns.pojo.ContactPojo;

public interface ContactRepository extends JpaRepository<ContactPojo, Integer> {

}
