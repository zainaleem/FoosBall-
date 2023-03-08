//package com.example.FoosBall.Entity;
//
//import com.example.FoosBall.Enum.PlayerSkill;
//
//import javax.persistence.*;
//
//@Entity(name = "player_rating")
//public class PlayerRating {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "player_rating_id")
//    private Long id;
//
//    @Column(name="fore_hand_skill")
//    @Enumerated(value = EnumType.STRING)
//    private PlayerSkill foreHandSkill;
//
//    @Column(name="back_hand_skill")
//    @Enumerated(value = EnumType.STRING)
//    private PlayerSkill backHandSkill;
//
//    @OneToOne(mappedBy = "playerRating")
//    private Player player;
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public PlayerSkill getForeHandSkill() {
//        return foreHandSkill;
//    }
//
//    public void setForeHandSkill(PlayerSkill foreHandSkill) {
//        this.foreHandSkill = foreHandSkill;
//    }
//
//    public PlayerSkill getBackHandSkill() {
//        return backHandSkill;
//    }
//
//    public void setBackHandSkill(PlayerSkill backHandSkill) {
//        this.backHandSkill = backHandSkill;
//    }
//
//    public Player getPlayer() {
//        return player;
//    }
//
//    public void setPlayer(Player player) {
//        this.player = player;
//    }
//}
