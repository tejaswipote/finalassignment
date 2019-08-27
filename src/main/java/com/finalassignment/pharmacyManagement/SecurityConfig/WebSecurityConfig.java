package com.finalassignment.pharmacyManagement.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/allMedicine").hasRole("USER")
                .antMatchers("/addMedicine").hasRole("ADMIN")
                .and()
                .csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("password")).roles("USER", "ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




    //
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
//
//



//        authenticationMgr.inMemoryAuthentication()
//                .withUser("user").password("pass").authorities("USER")
//                .and()
//                .withUser("admin").password("pass").authorities("USER","ADMIN");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//








//
//        http.authorizeRequests()
//                .antMatchers("/allPharmacist").permitAll()
//                .antMatchers("/allMedicine").hasAnyRole("USER","ADMIN")//.access("hasRole('USER') or hasRole('ADMIN')")
//                .antMatchers("/addSale").hasAnyRole("USER")
//                .antMatchers("/addMedicine").hasRole("ADMIN").anyRequest().authenticated()
//                .and().httpBasic();
////

    //}
}
