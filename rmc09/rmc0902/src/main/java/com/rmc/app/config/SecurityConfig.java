package com.rmc.app.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.cglib.core.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
        .requestMatchers("/cuenta/").permitAll()
        .requestMatchers("/cuenta/new").hasAnyRole("ADMIN", "Titular")
        .requestMatchers("/cuenta/").authenticated()
        



        .requestMatchers("/").permitAll()
        .requestMatchers("/new/**").hasAnyRole("USER","ADMIN")
        .requestMatchers("/edit/**", "/delete/**").hasRole("ADMIN")
        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
        .requestMatchers("/h2-console/**").hasRole("ADMIN")
        .anyRequest().authenticated())
        .formLogin(formLogin -> formLogin
        .defaultSuccessUrl("/", true)
        .permitAll())
        .logout(logout -> logout
        .permitAll())
        // .csrf(csrf -> csrf.disable())
        .httpBasic(Customizer.withDefaults());
        http.exceptionHandling(exceptions -> exceptions.accessDeniedPage("/accessError"));
        return http.build();
    }
}