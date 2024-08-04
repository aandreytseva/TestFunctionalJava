package org.example.service;

import org.example.domain.Privilege;
import org.example.domain.User;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService{
    @Override
    public List<String> getFirstNamesReverseSorted(List<User> users) {
        return users.stream()
                .map(user -> user.getFirstName())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    @Override
    public List<Privilege> getAllDistinctPrivileges(List<User> users) {
        return users.stream()
                .flatMap(user -> user.getPrivileges().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> getUserWithAgeHigherThan(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .findAny();
    }

    @Override
    public double getAverageAgeForUsers(List<User> users) {
        return users.stream()
                .mapToDouble(User::getAge)
                .average()
                .orElse(-1);
    }
}
