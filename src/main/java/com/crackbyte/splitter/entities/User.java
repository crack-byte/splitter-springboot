package com.crackbyte.splitter.entities;

import java.util.List;

import com.crackbyte.splitter.dto.UserDTO;

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
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String mobile;
    private String role;
    @OneToMany(
            mappedBy = "user"
    )
    private List<Address> addresses;

    
    public User() {
    }
    public User(UserDTO dto){
        this.username = dto.getUsername();
        this.password = dto.getPassword();
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.mobile = dto.getMobile();
        this.role = dto.getRole();
    }
}
