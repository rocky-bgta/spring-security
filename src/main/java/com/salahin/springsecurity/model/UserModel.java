package com.salahin.springsecurity.model;

import com.salahin.springsecurity.entity.RoleEntity;
import lombok.Data;

import java.util.List;

@Data
public class UserModel {
	private String username;
	private String password;
	private List<RoleEntity> roleList;
}
