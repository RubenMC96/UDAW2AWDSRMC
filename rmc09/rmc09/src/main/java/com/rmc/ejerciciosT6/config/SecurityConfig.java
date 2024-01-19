package com.rmc.ejerciciosT6.config;

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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
   http.headers(
       headersConfigurer -> headersConfigurer
           .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
   http.authorizeHttpRequests(auth -> auth
       .requestMatchers(new AntPathRequestMatcher[] {
           new AntPathRequestMatcher("/"),
           new AntPathRequestMatcher("/list")
       }).permitAll()
       .requestMatchers(new AntPathRequestMatcher("/nuevo/**")).authenticated()
       .requestMatchers(new AntPathRequestMatcher[]{
           new AntPathRequestMatcher("/editar/**"),
           new AntPathRequestMatcher("/borrar/**")
       }).hasAnyRole("MANAGER","ADMIN")
       .requestMatchers(new AntPathRequestMatcher[]{
           new AntPathRequestMatcher("/listado1/**"),
           new AntPathRequestMatcher("/listado2/**")
       }).hasRole("ADMIN")
       .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
       .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).hasRole("ADMIN")
       .anyRequest().authenticated())
   .formLogin(formLogin -> formLogin
       .defaultSuccessUrl("/", true)
       .permitAll())
   .logout(logout -> logout
       .logoutSuccessUrl("/")
       .permitAll())
   .httpBasic(Customizer.withDefaults());
   http.exceptionHandling(exceptions -> exceptions.accessDeniedPage("/"));
   return http.build();
}
}

