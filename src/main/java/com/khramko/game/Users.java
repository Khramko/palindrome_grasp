package com.khramko.game;

import com.khramko.game.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

//Singleton. Object stores progress information and players in the usersHashMap fields.
// Provides Top5 method that returns an array of five users with the largest amount of points.
public class Users implements Serializable {
    static final long serialVersionUID = 1;
    public HashMap<String, User> usersHashMap;

    private Users(){
        this.usersHashMap = new HashMap<>();
    }

    private static Users uniqueInstance;
    public static synchronized Users getInstance(){
        loadUsers();
        if (uniqueInstance == null){
            uniqueInstance = new Users();
        }
        return uniqueInstance;
    }



    private static void loadUsers() {

        File file = new File("users.bin");
        if (file.exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(
                    new FileInputStream("users.bin")
            )) {
                Users.uniqueInstance = ((Users) inputStream.readObject());

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            saveUsers();
        }
 }

    public static void saveUsers() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("users.bin")
        )) {
            outputStream.writeObject(uniqueInstance);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public User createOrGetUser(String name) {
        User userOutput;
        if (this.usersHashMap.containsKey(name)) {
            userOutput = this.usersHashMap.get(name);
        } else {
            userOutput = new User(name);
            usersHashMap.put(name, userOutput);
        }
        return userOutput;
    }

    public User [] getTop5(){
        ArrayList<User> usersArrayList = new ArrayList<>(this.usersHashMap.values());
        Collections.sort(usersArrayList);
        int a = usersArrayList.size();
        int d;
        if (a<5){d=a;}else{d=5;}
        //System.out.println(usersArrayList);
        User [] top5 = new User[d];
        for(int i=0; i<d; i++){
            top5[i]=usersArrayList.get(i);
        }
        return top5;
    }

    @Override
    public String toString() {
        return "Users{" +
                "usersHashMap=" + usersHashMap +
                '}';
    }
}
