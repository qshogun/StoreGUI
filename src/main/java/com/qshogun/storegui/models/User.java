package com.qshogun.storegui.models;

public class User {
    private String firstName;
    private String lastName;
    private String password;
    private String dayOfBirth;
    private String monthOfBirth;
    private String yearOfBirth;
    private String addressMain;
    private String city;
    private String state;
    private String postcode;
    private String country;
    private String phoneMobileNumber;

    public static class Builder {
        User user = new User();

        public Builder setFirstName(String firstName) {
            user.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            user.lastName = lastName;
            return this;
        }

        public Builder setPassword(String password) {
            user.password = password;
            return this;
        }

        public Builder setDayOfBirth(String dayOfBirth) {
            user.dayOfBirth = dayOfBirth;
            return this;
        }

        public Builder setMonthOfBirth(String monthOfBirth) {
            user.monthOfBirth = monthOfBirth;
            return this;
        }

        public Builder setYearOfBirth(String yearOfBirth) {
            user.yearOfBirth = yearOfBirth;
            return this;
        }

        public Builder setAddressMain(String addressMain) {
            user.addressMain = addressMain;
            return this;
        }

        public Builder setCity(String city) {
            user.city = city;
            return this;
        }

        public Builder setState(String state) {
            user.state = state;
            return this;
        }

        public Builder setPostcode(String postcode) {
            user.postcode = postcode;
            return this;
        }

        public Builder setCountry(String country) {
            user.country = country;
            return this;
        }

        public Builder setPhoneMobileNumber(String phoneMobileNumber) {
            user.phoneMobileNumber = phoneMobileNumber;
            return this;
        }

        public User build() {
            return user;
        }

    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPassword() {
        return password;
    }
    public String getDayOfBirth() {
        return dayOfBirth;
    }
    public String getMonthOfBirth() {
        return monthOfBirth;
    }
    public String getYearOfBirth() {
        return yearOfBirth;
    }
    public String getAddressMain() {
        return addressMain;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getPostcode() {
        return postcode;
    }
    public String getCountry() {
        return country;
    }
    public String getPhoneMobileNumber() {
        return phoneMobileNumber;
    }





}
