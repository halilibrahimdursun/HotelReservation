package com.application.util;

import com.github.javafaker.Faker;

public class FakerUtil {

    private static final Faker faker = new Faker();

    public static String getFakeEmailAddress(){

        String email = faker.name().firstName() +
                "." +
                faker.name().lastName() +
                "@capgemini.com";

        return email.toLowerCase();

    }
}
