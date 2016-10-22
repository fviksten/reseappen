package com.sallskapsresan;

/**
 * Created by Administrator on 2016-10-22.
 */
public class MyFavoriteDestinations {

    private User user;
    private Destinations favoriteDestinations;

    public MyFavoriteDestinations() {
        this.user = new User();
        this.favoriteDestinations = new Destinations();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setFavoriteDestinations(Destinations favoriteDestinations) {
        this.favoriteDestinations = favoriteDestinations;
    }

    public User getUser() {
        return user;
    }

    public Destinations getFavoriteDestinations() {
        return favoriteDestinations;
    }
}
