package com.materializedview.service;

import com.materializedview.model.User;

import java.util.List;

public interface UserService {

   void saveListUser(List<User> list);

    List<User> getListUser();
}