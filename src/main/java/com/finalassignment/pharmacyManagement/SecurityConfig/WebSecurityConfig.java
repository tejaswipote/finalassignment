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
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/allMedicine", "addSale").permitAll()
                .antMatchers("/getMedicine/{medicineId}", "/updateMedicine/{id}", "/allSales", "/allExpired", "/deleteExStock/{id}").hasAnyRole("PHARMACIST", "ADMIN")
                .antMatchers("/addMedicine", "/deleteMedicine/{id}", "/addPharmacist", "/allPharmacist", "deletePharmacist/{id}", "/getPharmacist/{id}", "/exPharmacist", "/getExPharmacist/{id}").hasRole("ADMIN")
                .and()
                .csrf().disable();
    }

    /**
     * This method sets roles , username and password
     * @param auth
     * @throws Exception
     */

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("password")).roles("PHARMACIST")
                .and()
                .withUser("admin").password(passwordEncoder().encode("password")).roles("ADMIN");
    }

    /**
     *
     * This method perform Encryption
     */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
