package com.trainibit.test_validations.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trainibit.test_validations.entity.UserData;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long>{
}