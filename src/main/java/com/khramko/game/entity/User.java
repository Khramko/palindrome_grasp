package com.khramko.game.entity;

import java.io.Serializable;
import java.util.ArrayList;


public class User implements Serializable, Comparable<User> {
    static final long serialVersionUID = 1L;
    private int ID;
    private String userName;
    private int scores;
    private ArrayList<String> enteredPalindromes;


//    public User() {
//    }

    public User(String name) {
        this.userName = name;
        this.enteredPalindromes = new ArrayList<>();
    }


    public String getUserName() {
        return userName;
    }


    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }


    public boolean isItNewUserString(String cutStr) {
        if (this.enteredPalindromes.isEmpty()) {
            System.out.println("empty enteredPalindromes, new string");
            enteredPalindromes.add(cutStr);
            return true;
        } else if (this.enteredPalindromes.contains(cutStr)) {
            System.out.println("contains string");
            return false;
        } else {
            this.enteredPalindromes.add(cutStr);
            System.out.println("new string");
            return true;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (ID != user.ID) return false;
        if (scores != user.scores) return false;
        if (!userName.equals(user.userName)) return false;
        return enteredPalindromes != null ? enteredPalindromes.equals(user.enteredPalindromes) : user.enteredPalindromes == null;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + userName.hashCode();
        result = 31 * result + scores;
        result = 31 * result + (enteredPalindromes != null ? enteredPalindromes.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(User anotherUser) {
        return anotherUser.scores - this.scores;
    }


}
