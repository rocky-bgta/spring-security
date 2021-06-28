package com.salahin.springsecurity.configuration;

import com.salahin.springsecurity.entity.RoleEntity;
import com.salahin.springsecurity.entity.UserEntity;
import com.salahin.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = new ArrayList<>();
		UserEntity userEntity;
		userEntity = userRepository.findByUsername(username);
		if(userEntity != null){
			for (RoleEntity roleEntity : userEntity.getRoleList()) {
				roles.add(new SimpleGrantedAuthority(roleEntity.getRoleName()));
			}
			return new User(userEntity.getUsername(),userEntity.getPassword(), roles);
		}
//		if(username.equals("admin")){
//			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//			return new User("admin","$2a$10$hZ6d9g1WRNqvHXtySt.1yO4L.PklA.fzodiTjv/4jHhlks4vSrhi2", roles);
//		}
//
//		if(username.equals("user")){
//			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
//			return new User("user","$2a$10$/iW5mfE.3iXS9vvRt7Etfe9pnObLtfRtJiiGhBML.G3yQZhRRmRhy", roles);
//		}
		
		throw new UsernameNotFoundException("User not found with the name"+ username);
	}
}
