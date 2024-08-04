package org.example.service;

import org.example.domain.Privilege;
import org.example.domain.User;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceImplTest {


    private UserService userService = new UserServiceImpl();

    private static final List<Privilege> ALL_PRIVILEGES = asList(Privilege.values());

    @Test
    public void shouldReturnFirstNamesSortedDesc() {
        final User user1 = new User(1L, "John", "Doe", 26, ALL_PRIVILEGES);
        final User user2 = new User(2L, "Greg", "Smith", 30, ALL_PRIVILEGES);
        final User user3 = new User(3L, "Alex", "Smith", 13, ALL_PRIVILEGES);

        final List<String> sortedFirstNames =
                userService.getFirstNamesReverseSorted(asList(user1, user2, user3));


        assertThat(sortedFirstNames).containsExactly("John", "Greg", "Alex");
    }

    @Test
    public void shouldReturnDistinctPrivilegesForUsers() {
        final User createUser = new User(1L, "John", "Doe", 26, singletonList(Privilege.CREATE));
        final User updateUser = new User(2L, "Greg", "Smith", 30, singletonList(Privilege.UPDATE));
        final User deleteUser = new User(3L, "Alex", "Smith", 13, singletonList(Privilege.DELETE));

        final List<Privilege> distinctPrivileges =
                userService.getAllDistinctPrivileges(asList(createUser, updateUser, deleteUser));

        assertThat(distinctPrivileges).containsExactlyInAnyOrder(Privilege.CREATE, Privilege.UPDATE, Privilege.DELETE);
    }

    @Test
    public void shouldReturnUpdateUserWithAgeHigherThanGiven() {
        final User updateUser1 = new User(1L, "John", "Doe", 26, singletonList(Privilege.UPDATE));
        final User updateUser2 = new User(2L, "Greg", "Smith", 30, singletonList(Privilege.UPDATE));
        final User deleteUser = new User(3L, "Alex", "Smith", 13, singletonList(Privilege.DELETE));

        final Optional<User> foundUser =
                userService.getUserWithAgeHigherThan(asList(updateUser1, updateUser2, deleteUser), 29);

        assertThat(foundUser).hasValueSatisfying(user ->
                assertThat(user).isEqualTo(updateUser2));
    }

    @Test
    public void getAverageAgeForUsers() {
        final int expectedAverage = 23;

        final User user1 = new User(1L, "John", "Doe", 26, singletonList(Privilege.UPDATE));
        final User user2 = new User(2L, "Greg", "Smith", 30, singletonList(Privilege.UPDATE));
        final User user3 = new User(3L, "Alex", "Smith", 13, singletonList(Privilege.DELETE));

        final double averageAge = userService.getAverageAgeForUsers(asList(user1, user2, user3));

        assertThat(averageAge).isEqualTo(expectedAverage);
    }
}