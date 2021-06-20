package com.salahin.springsecurity.configuration;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;
		if(username.equals("admin")){
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
			return new User("admin","$2a$10$hZ6d9g1WRNqvHXtySt.1yO4L.PklA.fzodiTjv/4jHhlks4vSrhi2", roles);
		}
		
		if(username.equals("user")){
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
			return new User("user","$2a$10$/iW5mfE.3iXS9vvRt7Etfe9pnObLtfRtJiiGhBML.G3yQZhRRmRhy", roles);
		}
		
		throw new UsernameNotFoundException("User not found with the name"+ username);
	}
}
