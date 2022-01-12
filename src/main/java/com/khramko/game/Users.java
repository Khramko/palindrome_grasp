package com.khramko.game;

import com.khramko.game.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Users implements Serializable, UserDAO {
    static final long serialVersionUID = 1L;
    private HashMap<String, User> usersHashMap;

    private Users() {
        this.usersHashMap = new HashMap<>();
    }

    private static Users uniqueInstance;

    public static synchronized Users getInstance() {
        loadUsers();
        if (uniqueInstance == null) {
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

    private static void saveUsers() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("users.bin")
        )) {
            outputStream.writeObject(uniqueInstance);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public User[] getTop5() {
        Users users = Users.getInstance();
        ArrayList<User> usersArrayList = new ArrayList<>(users.usersHashMap.values());
        Collections.sort(usersArrayList);
        int usersArrayListSize = usersArrayList.size();
        int tops5ArraySize = Math.min(usersArrayListSize, 5);
        User[] top5 = new User[tops5ArraySize];
        for (int i = 0; i < tops5ArraySize; i++) top5[i] = usersArrayList.get(i);
        return top5;
    }

    @Override
    public String toString() {
        return "Users{" +
                "usersHashMap=" + usersHashMap +
                '}';
    }

    @Override
    public User readUser(String userName) {
        if (usersHashMap.containsKey(userName)) {
            User userOutput = usersHashMap.get(userName);
            return userOutput;
        } else {
            throw new IllegalArgumentException("User " + userName + " not found");
        }
    }

    @Override
    public void createUser(String userName) {
        if (usersHashMap.containsKey(userName)) {
            throw new IllegalArgumentException("There is already created a user, named " + userName);
        }
        User userOutput = new User(userName);
        usersHashMap.put(userName, userOutput);
        saveUsers();
    }

    @Override
    public void updateUser(User user) {
        if (usersHashMap.containsKey(user.getUserName())) {
            usersHashMap.put(user.getUserName(), user);
            saveUsers();
        } else {
            throw new IllegalArgumentException("User " + user.getUserName() + " not found");
        }
    }

    @Override
    public void deleteUser(User user) {
        if (usersHashMap.containsKey(user.getUserName())) {
            usersHashMap.remove(user.getUserName());
            Users.saveUsers();
        } else {
            throw new IllegalArgumentException("User " + user.getUserName() + " not found");
        }
    }

}
