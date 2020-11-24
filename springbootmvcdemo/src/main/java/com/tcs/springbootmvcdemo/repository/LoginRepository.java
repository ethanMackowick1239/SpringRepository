package com.tcs.springbootmvcdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.springbootmvcdemo.model.Login;
@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

}
