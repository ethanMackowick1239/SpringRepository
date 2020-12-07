package com.tcs.assignment12.service;

import java.util.List;
import java.util.Optional;

import com.tcs.assignment12.model.Department;
import com.tcs.assignment12.model.Organization;

public interface OrganizationService {
	public String addOrganization(Organization organization);
	public Optional<Organization> findById(long id);
	public String deleteOrganization(long id);
	public String updateOrganization(long id, Organization organization);
	public Optional<List<Organization>> getOrganizations();
}
