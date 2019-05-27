package com.quiz.config;

import com.quiz.service.ApplicationProperties;
import com.quiz.service.EnvironmentService;
import com.quiz.service.UserService;
import com.quiz.service.security.LtiAuthenticationFilter;
import com.quiz.service.security.LtiAuthenticationProvider;
import com.quiz.service.security.LtiAuthenticationSuccessHandler;
import com.quiz.service.security.UsernameAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ApplicationProperties applicationProperties;


    @Autowired
    private UsernameAuthenticationProvider usernameAuthenticationProvider;

    @Autowired
    private LtiAuthenticationProvider ltiAuthenticationProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private EnvironmentService environmentService;

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager authenticationManager = super.authenticationManagerBean();
        return authenticationManager;
    }

    @Autowired
    public void configureAuthenticationManagerBuilder(AuthenticationManagerBuilder builder) throws Exception {
        builder.authenticationProvider(usernameAuthenticationProvider);
        //builder.authenticationProvider(ltiAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().cacheControl();
        http.headers().frameOptions().disable();

        http
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/**/*.css", "/**/*.map", "/**/*.js", "/**/*.html", "/**/*.ico").permitAll()
                .anyRequest().authenticated();

        http
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll();
        http
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .permitAll();


        http.csrf().ignoringAntMatchers("/api/**", "/ui/**");

        LtiAuthenticationSuccessHandler ltiAuthenticationSuccessHandler = new LtiAuthenticationSuccessHandler(applicationProperties);
        LtiAuthenticationFilter ltiAuthenticationFilter = new LtiAuthenticationFilter(
                userService,
                environmentService,
                applicationProperties,
                authenticationManager(),
                ltiAuthenticationSuccessHandler);

        http.addFilterBefore(ltiAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/**/*.css", "/**/*.map", "/**/*.js", "/**/*.html", "/**/*.ico");
        web.ignoring().antMatchers(HttpMethod.OPTIONS);
    }
}