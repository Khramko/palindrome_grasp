package com.khramko.game;

import com.khramko.game.entity.User;

public class Palindrome implements Playable{

    private String cutString(String str) {
        return str.replaceAll("\\p{Punct}|\\s+", "");
    }

    private boolean isPalindrome(String cutStr) {
        boolean isPalindrome = cutStr.equalsIgnoreCase(new StringBuffer(cutStr).reverse().toString());
        return isPalindrome;
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

            } else {
            System.out.println(user.getUserName() + " loose, scores = " + user.getScores());
            }
        users.usersHashMap.put(user.getUserName(), user);
        users.saveUsers();
    }
}
