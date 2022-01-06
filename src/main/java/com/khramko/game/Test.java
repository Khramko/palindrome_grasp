package com.khramko.game;

import com.khramko.game.entity.User;

public class Test {
    private static void testGame(String name, String palindrome){
        Users users = Users.getInstance();
        User user = users.createOrGetUser(name);
        Playable palindromeGamePlay = new Palindrome();
        user.playGame(palindrome, palindromeGamePlay);
    }
    public static void main(String[] args) {

       testGame("Georg","A tOyota! Race fast, safe car! A tOyota!");

       testGame("Georg", "Em to Greg: Gad! A dagger got me!");


        // System.out.println(Users.getInstance());

//    User petya = User.createOrGetUser("Petya");
//
//
//    User lena = User.createOrGetUser("Lena");
//
//    User ivan = User.createOrGetUser("Ivan");
//
//    User tanya = User.createOrGetUser("Tanya");
//
//    User gennadiy = User.createOrGetUser("Gennadiy");
//
//    User bill = User.createOrGetUser("Bill");

        //User naomi = User.createOrGetUser("Naomi");

        // PalindromeGamePlay palindromeGamePlay = new PalindromeGamePlay();

//
//    bill.userPlayPalindromeGame("Emu love volume!!!", palindromeGamePlay);
//
//    gennadiy.userPlayPalindromeGame("Eva, can I stab bats in a cave?", palindromeGamePlay);

        //  naomi.userPlayPalindromeGame("ABBA!!!", palindromeGamePlay);
        // lena.userPlayPalindromeGame("ABBA!!!", palindromeGamePlay);

//    bill.userPlayPalindromeGame("Erupt on Naomi? I moan, Not pure!", palindromeGamePlay);
//
//    tanya.userPlayPalindromeGame(".Пал, а норов худ и дух ворона лап", palindromeGamePlay);
        Users users = Users.getInstance();
        User [] top5 = users.getTop5();
        System.out.println();
        System.out.println("Leaders board");
        for (User user : top5) {
            System.out.println(user.getUserName());

        }
    }
}

