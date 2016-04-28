package br.com.timetrialfactory.model.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class Game {

    @Id
    @SequenceGenerator(name = "game_seq", sequenceName = "game_seq", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "game_seq")
    private Long id;

    @NotNull
    @Column(unique = true)
    private String title;

    @NotNull
    private Float price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

}
