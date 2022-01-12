package com.khramko.game;

import com.khramko.game.entity.User;

import java.io.IOException;


public class Test {
    private static void testGame(String name, String palindromeString) {
        Game palindromeGamePlay = new PalindromeGame(Users.getInstance());
        palindromeGamePlay.playGame(name, palindromeString);
    }
    public static void main(String[] args) throws IOException {
        Users users = Users.getInstance();
        //users.createUser("Ivan");
        User uriy = users.readUser("Uriy");
        users.deleteUser(uriy);
        testGame("Uriy","Erupt on Naomi? I moan, Not pure!");



       testGame("Georg","A tOyota! Race fast, safe car! A tOyota!");

       testGame("Georg", "m to Greg: Gad! A dagger got m");

        testGame("Georg", "Em to Greg: Gad! A dagger got me!");
        testGame("Georg", "Eva, can I stab bats in a cave?");
        testGame("Naomi", "Eva, can I stab bats in a cave?");

        testGame("Naomi", "Erupt on Naomi? I moan, Not pure!");

       // Users users = Users.getInstance();
        User [] top5 = users.getTop5();
        System.out.println();
        System.out.println("Leaders board");
        for (User user : top5) {
            System.out.println(user.getUserName());

        }
    }
}

