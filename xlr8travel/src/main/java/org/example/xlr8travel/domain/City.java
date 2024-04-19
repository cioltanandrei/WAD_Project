package org.example.xlr8travel.domain;


import lombok.*;
import jakarta.persistence.*;
import java.util.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {})
public class City {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public City(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Country country;

    public void setCountry(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    @OneToMany(mappedBy = "city", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Airport> airports = new HashSet<>();

    public void addAirport(Airport airport) {
        this.getAirports().add(airport);
        airport.setCity(this);
    }

    public void setAirports(Set<Airport> airports) {
        this.airports = airports;
    }


    @OneToMany(mappedBy = "city",  cascade = {CascadeType.PERSIST, CascadeType.MERGE})//, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Address> addresses = new HashSet<>();

    public void addAddress(Address address) {
        this.getAddresses().add(address);
        address.setCity(this);
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}