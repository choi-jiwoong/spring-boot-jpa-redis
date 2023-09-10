package com.example.spring.boot.jpa.user.service;

import com.example.spring.boot.jpa.user.entity.User;
import com.example.spring.boot.jpa.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;


  @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  public List<User> users() {

    return userRepository.findAll();
  }


}
