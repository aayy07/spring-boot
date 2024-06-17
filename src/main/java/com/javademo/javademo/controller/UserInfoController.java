package com.javademo.javademo.controller;

import com.javademo.javademo.entiry.UserInfoEntity;
import com.javademo.javademo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PreAuthorize("hasAuthority('SCOPE_READ')")
    @GetMapping
    public List<UserInfoEntity> findAll() {
        return userInfoService.findAll();
    }

    @PreAuthorize("hasAuthority('SCOPE_READ')")
    @GetMapping("/{id}")
    public Optional<UserInfoEntity> findById(@PathVariable Long id) {
        return userInfoService.findById(id);
    }

    @PreAuthorize("hasAuthority('SCOPE_WRITE')")
    @PostMapping
    public UserInfoEntity save(@RequestBody UserInfoEntity userInfo) {
        return userInfoService.save(userInfo);
    }

    @PreAuthorize("hasAuthority('SCOPE_WRITE')")
    @PutMapping("/{id}")
    public UserInfoEntity update(@PathVariable Long id, @RequestBody UserInfoEntity userInfo) {
        userInfo.setId(id);
        return userInfoService.save(userInfo);
    }

    @PreAuthorize("hasAuthority('SCOPE_WRITE')")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userInfoService.deleteById(id);
    }
}

