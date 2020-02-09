package com.shout.edu.config.auth;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.shout.edu.domain.user.Role;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private final CustomOAuth2UserService userService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().headers().frameOptions().disable()
			.and()
				.authorizeRequests()
				.antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/api/v1/**").permitAll()
				//.antMatchers("/api/v1/**").hasRole(Role.USER.name())
				.anyRequest().authenticated()
			.and()
				.logout()
					.logoutSuccessUrl("/")
			.and()
				.oauth2Login()
					.userInfoEndpoint()
						.userService(userService);
	}
}
