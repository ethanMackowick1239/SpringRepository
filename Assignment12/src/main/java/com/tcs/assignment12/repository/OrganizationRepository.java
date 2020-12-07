package com.tcs.assignment12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.assignment12.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
