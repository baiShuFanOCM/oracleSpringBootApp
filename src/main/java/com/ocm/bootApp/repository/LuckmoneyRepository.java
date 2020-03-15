package com.ocm.bootApp.repository;

import com.ocm.bootApp.domain.Luckymoney;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by oracleOCM
 * 2020-03-11 21:38
 */
public interface LuckmoneyRepository extends JpaRepository<Luckymoney, Integer> {

}
