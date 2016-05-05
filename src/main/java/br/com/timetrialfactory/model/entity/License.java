package br.com.timetrialfactory.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class License {

    @NotNull
    private Game game;

    @NotNull
    private User user;

    @Id
    @NotNull
    @Column(unique = true)
    private String key;

    private boolean checkedKey;

    // private Integer copies;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isCheckedKey() {
        return checkedKey;
    }

    public void setCheckedKey(boolean checkedKey) {
        this.checkedKey = checkedKey;
    }

}
