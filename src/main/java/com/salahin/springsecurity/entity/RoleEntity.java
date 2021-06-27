package com.salahin.springsecurity.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role")
public class RoleEntity {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id",unique = true)
	private String id;
	
	@Column(name = "role_name",unique = true)
	private String roleName;
}
