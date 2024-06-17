package com.javademo.javademo.service;

import com.javademo.javademo.entiry.UserInfoEntity;
import com.javademo.javademo.repo.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepo userInfoRepository;

    public List<UserInfoEntity> findAll() {
        return userInfoRepository.findAll();
    }

    public Optional<UserInfoEntity> findById(Long id) {
        return userInfoRepository.findById(id);
    }

    public UserInfoEntity save(UserInfoEntity userInfo) {
        return userInfoRepository.save(userInfo);
    }

    public void deleteById(Long id) {
        userInfoRepository.deleteById(id);
    }

    public Optional<UserInfoEntity> findByEmailId(String emailId) {
        return userInfoRepository.findByEmailId(emailId);
    }
}
