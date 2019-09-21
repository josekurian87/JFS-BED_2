package com.wipro.jfs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
            .antMatchers("/", "/login/do", "/register/do", "/registration/do", "/css/**", "/js/**").permitAll()
            .anyRequest().fullyAuthenticated()
            .and()
        .formLogin()
            .loginPage("/").permitAll()
//            .loginProcessingUrl("/login/do")
//            .defaultSuccessUrl("/home")
//            .failureUrl("/error")
            .and()
        .logout()
            .logoutSuccessUrl("/logout/do")
            .permitAll()
            .and()
        .csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/*.css");
		web.ignoring().antMatchers("/*.js");
	}
	
}
