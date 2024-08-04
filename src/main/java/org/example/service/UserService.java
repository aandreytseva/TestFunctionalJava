package org.example.service;

import org.example.domain.Privilege;
import org.example.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<String> getFirstNamesReverseSorted(List<User> users);


    List<Privilege> getAllDistinctPrivileges(List<User> users);

    Optional<User> getUserWithAgeHigherThan(List<User> users, int age);

    double getAverageAgeForUsers(List<User> users);


}
