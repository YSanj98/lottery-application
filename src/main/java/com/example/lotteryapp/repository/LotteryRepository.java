package com.example.lotteryapp.repository;

import com.example.lotteryapp.entity.Lottery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotteryRepository extends JpaRepository<Lottery, Long> {
}