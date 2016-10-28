package com.sallskapsresanDestinations;

import com.sallskapsresanUtils.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-10-22.
 */
public class MyFavoriteDestinations {

    private User user;
    private List<Long> favoriteDestinations;

    public MyFavoriteDestinations() {
        this.favoriteDestinations = new ArrayList<>();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setFavoriteDestinations(List<Long> favoriteDestinations) {
        this.favoriteDestinations = favoriteDestinations;
    }

    public User getUser() {
        return user;
    }

    public List<Long> getFavoriteDestinations() {
        return favoriteDestinations;
    }
}
