package com.khramko.game;

import com.khramko.game.entity.User;


public interface UserDAO {

        void createUser(String userName);

        User readUser(String userName);

        void updateUser(User user);

        void deleteUser(User user);

        User[] getTop5();

}

