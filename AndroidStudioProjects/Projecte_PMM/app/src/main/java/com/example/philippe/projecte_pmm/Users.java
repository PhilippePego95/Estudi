package com.example.philippe.projecte_pmm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Users   {
    String cod;
    String name;
    String pwd;

    public Users(String cod, String name, String pwd) {
        this.cod = cod;
        this.name = name;
        this.pwd = pwd;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
