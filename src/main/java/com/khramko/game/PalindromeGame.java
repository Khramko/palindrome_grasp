package com.khramko.game;

import com.khramko.game.entity.User;

import java.io.IOException;

public class PalindromeGame extends Game {

    public PalindromeGame(UserDAO userDAO) {
        super(userDAO);
    }

    private String cutString(String str) {
        return str.replaceAll("\\p{Punct}|\\s+", "");
    }

    private boolean isPalindrome(String cutStr) {
        return cutStr.equalsIgnoreCase(new StringBuffer(cutStr).reverse().toString());
    }

    private int calculateScores(String cutStr) {
        return cutStr.length();
    }

    @Override
    public void playGame(String userName, String str) throws IOException {
        String cutStr = cutString(str);
        User user = userDAO.readUser(userName);

            if (user.isItNewUserString(cutStr) && isPalindrome(cutStr)) {
            user.setScores(user.getScores() + calculateScores(cutStr));
            System.out.println(userName + " wins, scores = " + user.getScores());
            userDAO.updateUser(user);

            } else {
            System.out.println(userName + " loose, scores = " + user.getScores());
            }

    }
}
