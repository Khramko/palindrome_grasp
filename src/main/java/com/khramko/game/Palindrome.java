package com.khramko.game;

import com.khramko.game.entity.User;

public class Palindrome implements Playable{

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
    public void play(User user, String str) {
        String cutStr = cutString(str);
        Users users = Users.getInstance();

            if (isPalindrome(cutStr) & user.isItNewUserString(cutStr)) {
            user.setScores(user.getScores() + calculateScores(cutStr));
            user.addToEnteredPalindromesList(cutStr);

            System.out.println(user.getUserName() + " wins, scores = " + user.getScores());
                users.usersHashMap.put(user.getUserName(), user);
                Users.saveUsers();

            } else {
            System.out.println(user.getUserName() + " loose, scores = " + user.getScores());
            }

    }
}
