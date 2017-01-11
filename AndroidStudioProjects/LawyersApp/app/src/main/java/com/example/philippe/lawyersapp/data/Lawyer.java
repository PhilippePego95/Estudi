package com.example.philippe.lawyersapp.data;

/**
 * Created by philippe on 11/01/17.
 */

public class Lawyer {
    private String id;
    private String name;
    private String specialty;
    private String phoneNumber;
    private String bio;
    private String avatarUri;

    public Lawyer(String id, String name, String specialty, String phoneNumber, String bio, String avatarUri) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
        this.avatarUri = avatarUri;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBio() {
        return bio;
    }

    public String getAvatarUri() {
        return avatarUri;
    }
}
