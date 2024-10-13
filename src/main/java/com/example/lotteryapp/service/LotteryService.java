package com.example.lotteryapp.service;

import com.example.lotteryapp.entity.Guest;
import com.example.lotteryapp.entity.Lottery;
import com.example.lotteryapp.repository.GuestRepository;
import com.example.lotteryapp.repository.LotteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class LotteryService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private LotteryRepository lotteryRepository;

    private final Random random = new Random();

    public String generateTicket() {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }

        StringBuilder ticket = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(digits.size());
            ticket.append(digits.remove(index)).append(" ");
        }
        char letter = (char) ('A' + random.nextInt(26));
        ticket.append(letter);

        return ticket.toString().trim();
    }

    public Lottery createLottery(String ticket) {
        String drawnSequence = generateTicket();
        double jackpot = 1000.0;

        Lottery lottery = new Lottery();
        lottery.setLotterySequence(ticket);
        lottery.setDrawnSequence(drawnSequence);
        lottery.setJackpot(jackpot);
        lotteryRepository.save(lottery);

        return lottery;
    }

    public Guest registerGuest(String name, String mobile, String ticket) {
        Lottery lottery = createLottery(ticket);

        // Calculate winnings
        String[] guestNumbers = ticket.split(" ");
        String[] drawNumbers = lottery.getDrawnSequence().split(" ");

        int percentageWon = calculateWinnings(guestNumbers, drawNumbers);
        double amountWon = (percentageWon / 100.0) * lottery.getJackpot();

        // Save guest details
        Guest guest = new Guest();
        guest.setName(name);
        guest.setMobile(mobile);
        guest.setTicket(ticket);
        guest.setAmountWon(amountWon);
        guest.setPercentageWon(percentageWon);
        guest.setLottery(lottery);

        return guestRepository.save(guest);
    }

    private int calculateWinnings(String[] guestNumbers, String[] drawNumbers) {
        int percentageWon = 0;

        if (guestNumbers[4].equals(drawNumbers[4])) percentageWon += 10;

        for (int i = 0; i < 4; i++) {
            if (guestNumbers[i].equals(drawNumbers[i])) {
                percentageWon += 20;
            } else if (List.of(drawNumbers).contains(guestNumbers[i])) {
                percentageWon += 10;
            }
        }

        return percentageWon;
    }

    public List<Lottery> getAllLotteries() {
        return lotteryRepository.findAll();
    }




}