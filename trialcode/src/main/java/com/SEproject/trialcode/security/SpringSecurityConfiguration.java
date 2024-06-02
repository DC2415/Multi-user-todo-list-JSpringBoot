package com.SEproject.trialcode.security;

import java.util.function.Function;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
//InMemoryUserDetailsManager
//inMemoryUserDetailsManager(UserDetails... users)
@Bean
public InMemoryUserDetailsManager createuserdetailsmanager()
{  
UserDetails userDetails1 = createnewuser("rohan", "123");
UserDetails userDetails2 = createnewuser("deshmukhps_2", "2671");
     return new InMemoryUserDetailsManager(userDetails1,userDetails2);
}
private UserDetails createnewuser(String username, String password) {
	Function<String, String> passwordEncoder=input->passwordEncoder().encode(input);
	UserDetails userDetails = User.builder()
	                               .passwordEncoder(passwordEncoder)
	                               .username(username)
	                               .password(password)
	                               .roles("USER","ADMIN")
	                               .build();
	return userDetails;
}
@Bean
public PasswordEncoder passwordEncoder()
{
	return new BCryptPasswordEncoder();
}
@Bean
public SecurityFilterChain filterchain(HttpSecurity http)throws Exception
{
	http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
	http.csrf().disable();
	http.headers().frameOptions().disable();
	http.formLogin(withDefaults());
	return http.build();
}
}