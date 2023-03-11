package com.example.FoosBall.Entity;

import javax.persistence.*;

@Entity
public class PlayerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "player_detail_id")
    private Long id;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "cellNumber")
    private String cellNumber;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "playerDetails",orphanRemoval = true,fetch = FetchType.LAZY)
    private Player player;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
