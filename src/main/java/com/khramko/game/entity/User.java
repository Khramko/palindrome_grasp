package com.khramko.game.entity;
import com.khramko.game.Playable;
import com.khramko.game.Users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;


//User class, contains fields - state of a particular player (name, amount of won points, entered palindromes).
//Provides game-method userPlayPalindromeGame  and static method of obtaining already existing, or create a new user createOrGetUser .
//Class meets the Entity - class requirements, prepared to work with database.
public class User implements Serializable, Comparable<User> {
    static final long serialVersionUID = 1;
    private int ID;
    private String userName;
    private int scores;
    private ArrayList<String> enteredPalindromes;
    private Set<String> enteredPalindromesSet;

//    public User() {
//    }

    public User(String name) {
        this.userName = name;
        this.enteredPalindromes = new ArrayList<String>();
        }




    public void playGame(String str, Playable playable) {
     playable.play(this, str);

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public ArrayList<String> getEnteredPalindromes() {
        return enteredPalindromes;
    }

    public void setEnteredPalindromes(ArrayList<String> enteredPalindromes) {
        this.enteredPalindromes = enteredPalindromes;
    }
    public boolean isItNewUserString (String cutStr) {
        if (this.enteredPalindromes.isEmpty()) {
            System.out.println("empty new string");
            enteredPalindromes.add(cutStr);
            System.out.println(enteredPalindromes);
            return true;
        } else if (this.enteredPalindromes.contains(cutStr))
        {System.out.println("contains string");
            return false;}
        else{
            this.enteredPalindromes.add(cutStr);
            System.out.println("new string");
            return true;}
    }

    @Override
    public int compareTo(User anotherUser) {
        return anotherUser.scores-this.scores;
    }


    public void addToEnteredPalindromesList(String cutStr) {
        enteredPalindromes.add(cutStr);
    }
}
