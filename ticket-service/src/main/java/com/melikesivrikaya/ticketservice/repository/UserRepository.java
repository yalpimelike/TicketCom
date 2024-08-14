package com.melikesivrikaya.ticketservice.repository;

import com.melikesivrikaya.ticketservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface UserRepository  extends JpaRepository<User, Long> {
}
