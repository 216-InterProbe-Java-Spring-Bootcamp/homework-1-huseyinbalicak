package com.interpobe.balicak.repository;

import com.interpobe.balicak.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
