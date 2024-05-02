package org.example.xlr8travel.domain;
import lombok.*;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {})

public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private int age;
    private String gender; // enum?
    private String email;
    private String password;
    private LocalDate dob; // date of birth
    //  @Enumerated(EnumType.ORDINAL) // ?
    private Account_Status accountStatus; //

    // instead of @OneToMany when having collection of basic types or enums
    @ElementCollection(fetch = FetchType.EAGER)
    //private Set<String> roles = new HashSet<>();
    private List<Role> roles = new ArrayList<>(); // cand un user are mai multe roluri

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(Role role : roles)
            authorities.add(new SimpleGrantedAuthority(role.toString()));
        return authorities;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User(String firstname, String lastname, String username, int age, String gender, String email, String password, LocalDate dob, Account_Status accountStatus) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.accountStatus = accountStatus;
    }

    public User(String firstname, String lastname, String username, int age, String gender, String email, String password, LocalDate dob) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.dob = dob;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Account_Status getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Account_Status accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(firstname, user.firstname) && Objects.equals(lastname, user.lastname) && Objects.equals(username, user.username) && Objects.equals(gender, user.gender) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(dob, user.dob) && Objects.equals(roles, user.roles) && Objects.equals(accountStatus, user.accountStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, username, age, gender, email, password, dob, roles, accountStatus);
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Address> addresses = new HashSet<>();

    public void addAddress(Address address) {
        this.getAddresses().add(address);
        address.setUser(this);
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Ticket> tickets = new HashSet<>();

    public void addTicket(Ticket ticket) {
        this.getTickets().add(ticket);
        ticket.setUser(this);
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

   /* @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Payment> payments = new HashSet<>();

    public void addPayment(Payment payment) {
        this.getPayments().add(payment);
        payment.setUser(this);
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }


    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Notification> notifications = new HashSet<>();

    public void addNotification(Notification notification) {
        this.getNotifications().add(notification);
        notification.setUser(this);
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }*/
}
