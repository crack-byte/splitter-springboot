package com.crackbyte.splitter.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crackbyte.splitter.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
