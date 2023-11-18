package com.scaler.BookMyShow.repository;

import com.scaler.BookMyShow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    /*
    jpa helps to create query methods just by writing
    the method names, the internal sql implementation jpa
    takes care itself creates automatically
    It can be empty optional or optional with object

    */
    @Override
    Optional<User> findById(Long userId);

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndName(String email, String name);

    User save(User user);
}
