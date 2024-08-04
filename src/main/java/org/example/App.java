package org.example;

import org.example.domain.Privilege;
import org.example.domain.User;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        // create users
        User user1 = new User(1L, "Alice", "Smith", 30, Arrays.asList(Privilege.CREATE, Privilege.READ));
        User user2 = new User(2L, "Bob", "Johnson", 25, Arrays.asList(Privilege.UPDATE, Privilege.READ));
        User user3 = new User(3L, "Carol", "Williams", 35, Arrays.asList(Privilege.DELETE, Privilege.READ));
        User user4 = new User(4L, "Dave", "Brown", 28, Arrays.asList(Privilege.CREATE, Privilege.UPDATE, Privilege.READ));

        List<User> users = Arrays.asList(user1, user2, user3, user4);

        // test methods
        System.out.println("Reverse sorted first names: " + userService.getFirstNamesReverseSorted(users));
        System.out.println("All distinct privileges: " + userService.getAllDistinctPrivileges(users));
        System.out.println("Any user with age higher than 30: " + userService.getUserWithAgeHigherThan(users, 30));
        System.out.println("Average age of users: " + userService.getAverageAgeForUsers(users));
    }
}
