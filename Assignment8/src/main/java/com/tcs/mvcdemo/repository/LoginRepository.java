package com.tcs.mvcdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.mvcdemo.model.Login;
@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

}
