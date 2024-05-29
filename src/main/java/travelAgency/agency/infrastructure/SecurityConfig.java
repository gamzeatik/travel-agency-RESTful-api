package travelAgency.agency.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
public class SecurityConfig {

    private final LogoutHandler logoutHandler;
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    public SecurityConfig(LogoutHandler logoutHandler, JwtAuthenticationFilter jwtAuthFilter, AuthenticationProvider authenticationProvider) {
        this.logoutHandler = logoutHandler;
        this.jwtAuthFilter = jwtAuthFilter;
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/webjars/**",
                                "/swagger-resources/**",
                                "/configuration/ui",
                                "/configuration/security",
                                "/user/**",
                                "/about-us/about",
                                "/blogs/blog-list",
                                "/blogs/blog/**",
                                "/blogs/blog/",
                                "/contact-us/post-contact-us",
                                "reservation/post-reservation",
                                "tours/tour-list",
                                "tours/tour/**",
                                "tours/tour/",
                                "transfers/transfer-list",
                                "transfers/transfer/**",
                                "transfers/transfer/",
                                "vehicles/vehicle/**",
                                "vehicles/vehicle-list",
                                "vehicles/vehicle/",
                                "transfer-destinations/transfer-destination",
                                "transfer-destinations/transfer-destination/**",
                                "transfer-destinations/transfer-destinations-list",
                                "/list"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout -> logout
                        .logoutUrl("/user/logout")
                        .addLogoutHandler(logoutHandler)
                        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                );

        return http.build();
    }
}
//gamze
