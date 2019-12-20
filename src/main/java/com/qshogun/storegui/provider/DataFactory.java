package com.qshogun.storegui.provider;

import com.qshogun.storegui.models.User;
import com.qshogun.storegui.util.DataGenerator;
import org.seleniumhq.jetty9.server.Authentication;

public class DataFactory {

    public static User getUser() {
        return new User.Builder()
                .setFirstName(DataGenerator.getFirstName())
                .setLastName(DataGenerator.getLastName())
                .setPassword(DataGenerator.getPassword())
                .setDayOfBirth(DataGenerator.getDayOfBirth())
                .setMonthOfBirth(DataGenerator.getMonthOfBirth())
                .setYearOfBirth(DataGenerator.getYearOfBirth())
                .setAddressMain(DataGenerator.getAddressMain())
                .setCity(DataGenerator.getCity())
                .setState(DataGenerator.getState())
                .setPostcode(DataGenerator.getPostcode())
                .setCountry(DataGenerator.getCountry())
                .setPhoneMobileNumber(DataGenerator.getPhoneMobileNumber())
                .build();
    }
}
