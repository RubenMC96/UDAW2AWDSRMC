package com.rmc.app.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
@Bean
public AuthenticationManager authenticationManager(
AuthenticationConfiguration authenticationConfiguration)
throws Exception {return authenticationConfiguration.getAuthenticationManager();
}
@Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }



@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.headers(headersConfigurer -> headersConfigurer
    .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
    http.authorizeHttpRequests(
    auth -> auth
    .requestMatchers("/").permitAll()
    .requestMatchers("/cuenta/").permitAll()
    .requestMatchers("/cuenta/new/**").hasAnyRole("ADMIN", "TITULAR")
    .requestMatchers("/cuenta/delete/**").hasRole("ADMIN")
        
    .requestMatchers("/movimientos/new/**").hasRole("TITULAR")        .requestMatchers("/movimientos/**").authenticated()
        
    .requestMatchers("/usuario/").hasRole("ADMIN")
    .requestMatchers("/usuario/nuevo/**").permitAll()
    .requestMatchers("/usuario/borrar/**").hasRole("ADMIN")

    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
    .requestMatchers("/h2-console/**").hasRole("ADMIN")
    .anyRequest().permitAll())
    .formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer
    .loginPage("/signin") // mapping par mostrar formulario de login

    .loginProcessingUrl("/login") // ruta post de /signin

    .failureUrl("/signin")
    .defaultSuccessUrl("/home", true).permitAll())
    .logout((logout) -> logout
    .logoutSuccessUrl("/home").permitAll())
    // .csrf(csrf -> csrf.disable())
    .httpBasic(Customizer.withDefaults());
    http.exceptionHandling(exceptions -> exceptions.accessDeniedPage("/accessError"));
    return http.build();
}
}