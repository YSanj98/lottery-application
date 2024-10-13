package com.example.lotteryapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Lottery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lotteryId;
    private String lotterySequence;
    private String drawnSequence;
    private Double jackpot;

    @OneToMany(mappedBy = "lottery")
    @JsonManagedReference
    private List<Guest> guests;

    public Long getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(Long lotteryId) {
        this.lotteryId = lotteryId;
    }

    public String getLotterySequence() {
        return lotterySequence;
    }

    public void setLotterySequence(String lotterySequence) {
        this.lotterySequence = lotterySequence;
    }

    public String getDrawnSequence() {
        return drawnSequence;
    }

    public void setDrawnSequence(String drawnSequence) {
        this.drawnSequence = drawnSequence;
    }

    public Double getJackpot() {
        return jackpot;
    }

    public void setJackpot(Double jackpot) {
        this.jackpot = jackpot;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }
}
