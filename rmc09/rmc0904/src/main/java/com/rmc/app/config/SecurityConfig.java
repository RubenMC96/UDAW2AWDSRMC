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
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.headers(headersConfigurer -> headersConfigurer
                .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
        http.authorizeHttpRequests(
                auth -> auth

                        .requestMatchers("/categoria/**").hasAnyRole("ADMIN", "MANAGER")

                        .requestMatchers("/productos/**").hasAnyRole("ADMIN", "MANAGER")

                        .requestMatchers("/usuario/").hasAnyRole("ADMIN", "MANAGER")
                        .requestMatchers("/usuario/nuevo/**", "/usuario/editar/**", "/usuario/borrar/**")
                        .hasRole("ADMIN")

                        .requestMatchers("/valoracion/nuevo/**").hasAnyRole("MANAGER", "ADMIN", "USER")
                        .requestMatchers("/valoracion/usuario/**", "/valoracion/editar/**", "/valoracion/borrar/**")
                        .hasAnyRole("MANAGER", "ADMIN")

                        .requestMatchers("/", "/public/**", "/categoria/", "/producto/",
                                "/valoracion/producto/**")
                        .permitAll()

                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/h2-console/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
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