package com.example.lotteryapp.controller;

import com.example.lotteryapp.entity.Guest;
import com.example.lotteryapp.entity.Lottery;
import com.example.lotteryapp.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LotteryController {

    @Autowired
    private LotteryService lotteryService;

    @PostMapping("/tickets")
    public Guest registerGuest(@RequestBody Guest guest) {
        return lotteryService.registerGuest(guest.getName(), guest.getMobile(), guest.getTicket());
    }

    @GetMapping("/lotteries")
    public List<Lottery> getAllLotteries() {
        return lotteryService.getAllLotteries();
    }



}
