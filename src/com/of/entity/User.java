package com.of.entity;

import java.util.Arrays;
import java.util.Objects;

public class User {
    private Integer uid;
    private String uname;
    private String gender;
    private Hobby[] hobbys;

    public User() {
    }

    public User(Integer uid, String uname, String gender, Hobby[] hobbys) {
        this.uid = uid;
        this.uname = uname;
        this.gender = gender;
        this.hobbys = hobbys;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Hobby[] getHobbys() {
        return hobbys;
    }

    public void setHobbys(Hobby[] hobbys) {
        this.hobbys = hobbys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return uid.equals(user.uid) && uname.equals(user.uname) && gender.equals(user.gender) && Arrays.equals(hobbys, user.hobbys);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(uid, uname, gender);
        result = 31 * result + Arrays.hashCode(hobbys);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", gender='" + gender + '\'' +
                ", hobbys=" + Arrays.toString(hobbys) +
                '}';
    }
}
