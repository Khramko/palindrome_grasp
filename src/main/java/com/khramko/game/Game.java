package com.khramko.game;


 abstract class Game {
    UserDAO userDAO;

    protected Game(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    protected abstract void playGame(String userName, String str);
}
