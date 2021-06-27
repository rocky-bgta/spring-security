package com.salahin.springsecurity.repository;

import com.salahin.springsecurity.entity.UserEntity;
import com.salahin.springsecurity.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
	UserModel findByUsername(String username);
}
