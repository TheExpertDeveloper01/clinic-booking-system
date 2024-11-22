package com.P2.CBS.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Table(name = "app_users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id, unique = true, nullable = false")
    private Long patientId;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
    // Other fields...

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return user authorities
        return null; // Replace with actual authorities
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Customize as needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Customize as needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Customize as needed
    }

    @Override
    public boolean isEnabled() {
        return true; // Customize as needed
    }
}


//package com.P2.CBS.model;
//
//import jakarta.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "users")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String username;
//
//    private String password;
//
//    @ElementCollection(fetch = FetchType.EAGER)
//    private List<String> authorities;
//
//    // Constructors, getters, and setters
//    public User() {}
//
//    public User(String username, String password, List<String> authorities) {
//        this.username = username;
//        this.password = password;
//        this.authorities = authorities;
//    }
//
//    // Getters and setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public List<String> getAuthorities() {
//        return authorities;
//    }
//
//    public void setAuthorities(List<String> authorities) {
//        this.authorities = authorities;
//    }
//}
//



//package com.P2.CBS.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import org.springframework.security.core.GrantedAuthority;
//
//import java.util.Collection;
//
//@Entity
//@Table(name = "users")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @NotNull
//    private String username;
//
//    @NotNull
//    private String password;
//
//    // Assuming there's a way to get user authorities
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_authorities",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "authority_id")
//    )
//    private Collection<GrantedAuthority> authorities;
//
//    // Constructors, getters and setters
//    public User() {}
//
//    public User(String username, String password, Collection<GrantedAuthority> authorities) {
//        this.username = username;
//        this.password = password;
//        this.authorities = authorities;
//    }
//
//    // Getters and setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Collection<GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    public void setAuthorities(Collection<GrantedAuthority> authorities) {
//        this.authorities = authorities;
//    }
//}


//package com.P2.CBS.model;
//
//import jakarta.validation.constraints.NotNull;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import jakarta.persistence.*;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Entity
//@Table(name = "users")
//public class User implements UserDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotNull
//    private String username;
//
//    @NotNull
//    private String password;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Collection<Role> roles;
//
//    // Getters and Setters
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toList());
//    }
//
//    public void setRoles(Collection<Role> roles) {
//        this.roles = roles;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//}


//package com.P2.CBS.model;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import org.springframework.security.core.userdetails.UserDetails;
//
//import jakarta.persistence.*;
//import java.util.Collection;
//
//@Entity
//@Table(name = "users")
//public class User implements UserDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String username;
//    private String password;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Collection<SimpleGrantedAuthority> authorities;
//
//    // Getters and Setters
//
//    public Long getId(){
//        return id;
//    }
//
//    public void setId(Long id){
//        this.id = id;
//    }
//
//    @Override
//    public String getUsername(){
//        return username;
//    }
//
//    public void setUsername(String username){
//        this.username = username;
//    }
//
//    @Override
//    public String getPassword(){
//        return password;
//    }
//
//    public void setPassword(String password){
//        this.password = password;
//    }
//
//    @Override
//    public Collection<SimpleGrantedAuthority> getAuthorities(){
//        return authorities;
//    }
//
//    public void setAuthorities(Collection<SimpleGrantedAuthority> authorities){
//        this.authorities = authorities;
//    }
//
//    @Override
//    public boolean isAccountNonExpired(){
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked(){
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired(){
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled(){
//        return true;
//    }
//
//}
