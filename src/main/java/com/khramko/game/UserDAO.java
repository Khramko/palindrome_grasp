package com.khramko.game;

import com.khramko.game.entity.User;

import java.io.IOException;
import java.util.NoSuchElementException;

public interface UserDAO {

        void createUser(String userName);

        User readUser(String userName);

        void updateUser(User user);

        void deleteUser(User user);

        User[] getTop5();

}

