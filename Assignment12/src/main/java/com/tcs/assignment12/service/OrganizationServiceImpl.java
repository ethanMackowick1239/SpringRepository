package com.tcs.assignment12.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.assignment12.model.Department;
import com.tcs.assignment12.model.Organization;
import com.tcs.assignment12.repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	OrganizationRepository organizationRepository;
	
	@Override
	public String addOrganization(Organization organization) {
		Organization organization2 = null;
		try {
			organization2 = organizationRepository.save(organization);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public Optional<Organization> findById(long id) {
		return organizationRepository.findById(id);
	}

	@Override
	public String deleteOrganization(long id) {
		organizationRepository.deleteById(id);
		return "success";
	}

	@Override
	public String updateOrganization(long id, Organization organization) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Organization>> getOrganizations() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(organizationRepository.findAll());
	}

}
