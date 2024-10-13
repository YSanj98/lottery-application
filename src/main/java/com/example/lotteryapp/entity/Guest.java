package com.example.lotteryapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guestId;
    private String name;
    private String mobile;
    private String ticket;
    private Double amountWon;
    private Integer percentageWon;

    @ManyToOne
    @JoinColumn(name = "lottery_id")
    @JsonIgnore
    private Lottery lottery;

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Double getAmountWon() {
        return amountWon;
    }

    public void setAmountWon(Double amountWon) {
        this.amountWon = amountWon;
    }

    public Integer getPercentageWon() {
        return percentageWon;
    }

    public void setPercentageWon(Integer percentageWon) {
        this.percentageWon = percentageWon;
    }

    public Lottery getLottery() {
        return lottery;
    }

    public void setLottery(Lottery lottery) {
        this.lottery = lottery;
    }
}
