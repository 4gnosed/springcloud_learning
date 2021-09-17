package com.macro.cloud.service;

import com.macro.cloud.pojo.User;

import java.util.List;

/**
 * @Package: com.macro.cloud.service
 * @Description:
 * @Author: LuDeSong
 * @Date: 2021-9-17 10:05
 */

public interface UserService {
    void create(User user);

    User getUser(Long id);

    void update(User user);

    void delete(Long id);

    User getByUsername(String username);

    List<User> getUserByIds(List<Long> ids);
}
