package org.example.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class User {
    private Long id;

    private String firstName;

    private String lastName;

    private Integer age;

    private List<Privilege> privileges;

    public User(final Long id,
                final String firstName,
                final String lastName,
                final Integer age,
                final List<Privilege> privileges) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.privileges = Collections.unmodifiableList(privileges);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User that = (User) obj;
        return id == that.id &&
                age == that.age &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(privileges, that.privileges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, firstName, lastName, privileges);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", privileges=" + privileges +
                '}';
    }
}
