package com.materializedview.service.impl;

import com.materializedview.model.User;
import com.materializedview.repository.UserRepository;
import com.materializedview.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void saveListUser(List<User> list) {
        userRepository.saveAll(list);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getListUser() {
        return userRepository.findAll();
    }
}
