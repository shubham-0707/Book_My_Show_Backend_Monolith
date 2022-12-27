package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity ,Integer> {
}
