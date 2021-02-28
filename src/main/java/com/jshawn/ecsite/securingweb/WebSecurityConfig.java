package com.jshawn.ecsite.securingweb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.jshawn.ecsite.model.Users;
import com.jshawn.ecsite.service.UsersService;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private UsersService usersService;
	
	@Autowired
	public WebSecurityConfig(UsersService usersService) {
		this.usersService = usersService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/", "/css/**", "/image/**", "/js/**").permitAll()
				.antMatchers("/checkout").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
				.anyRequest().authenticated();

		http.csrf().disable();
		
		http.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/home")
				.permitAll();
		
		http.logout()
				.deleteCookies("JSESSIONID")
				.invalidateHttpSession(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login");
	
		http.sessionManagement()
				.maximumSessions(1)
				.sessionRegistry(sessionRegistry());
	}
	
	@Bean
	public SessionRegistry sessionRegistry() {
	    return new SessionRegistryImpl();
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		List<UserDetails> userDetailsList = new ArrayList<>();
		Iterable<Users> usersList = usersService.findAll();
		
		for(Users u: usersList) {
			userDetailsList.add(
					User.withUsername(u.getUsername())
						.password(
							passwordEncoder()
							.encode(u.getPass())
						)
						.roles(u.getRole()).build());
		}
		
		return new InMemoryUserDetailsManager(userDetailsList);
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
