package com.qshogun.storegui.util;

import com.github.javafaker.Faker;

public class DataGenerator {

    private static Faker faker = new Faker();

    public static String getFirstName() {
        return faker.name().firstName();
    }
    public static String getLastName() {
        return faker.name().lastName();
    }
    public static String getPassword() {
        return faker.internet().password(5, 10);
    }
    public static String getDayOfBirth() {
        return "1";
    }
    public static String getMonthOfBirth() {
        return "June";
    }
    public static String getYearOfBirth() {
        return "2000";
    }
    public static String getAddressMain() {
        return faker.address().fullAddress();
    }
    public static String getCity() {
        return faker.address().city();
    }
    public static String getState() {
        return "A";
    }
    public static String getPostcode() {
        return "12345";
    }
    public static String getCountry() {
        return "United States";
    }
    public static String getPhoneMobileNumber() {
        return faker.phoneNumber().cellPhone();
    }
}
