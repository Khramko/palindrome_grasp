package com.khramko.game;



import java.io.IOException;

 abstract class Game {
    UserDAO userDAO;

    protected Game(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    protected abstract void playGame(String userName, String str) throws IOException;
}
