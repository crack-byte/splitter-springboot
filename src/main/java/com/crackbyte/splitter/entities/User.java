package com.crackbyte.splitter.entities;

import java.util.HashSet;
import java.util.Set;

import com.crackbyte.splitter.dto.UserDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String username;
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String mobile;
    private String role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Address> addresses;

    public User() {
    }

    public void addAddress(Address address) {
        if (addresses == null) {
            addresses = new HashSet<>();
        }
        address.setUser(this);
        addresses.add(address);
    }

    public User(UserDTO dto) {
        this.username = dto.getUsername();
        this.password = dto.getPassword();
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.mobile = dto.getMobile();
        this.role = dto.getRole();
        dto.getAddresses().forEach(address -> {
            this.addAddress(new Address(address));
        });
    }
}
