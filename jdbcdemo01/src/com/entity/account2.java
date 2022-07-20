package com.entity;

public class account2 {
    private Integer aid;
    private String username;
    private String password;
    private Double money;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public account2() {
    }

    public account2(Integer aid, String username, String password, Double money) {
        this.aid = aid;
        this.username = username;
        this.password = password;
        this.money = money;
    }

    @Override
    public String toString() {
        return "account2{" +
                "aid=" + aid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}';
    }
}
