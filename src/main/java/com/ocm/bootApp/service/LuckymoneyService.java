package com.ocm.bootApp.service;

import com.ocm.bootApp.enums.AppExceptionEnum;
import com.ocm.bootApp.exception.AppException;
import com.ocm.bootApp.repository.LuckmoneyRepository;
import com.ocm.bootApp.domain.Luckymoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Created by oracleOCM
 * 2020-03-12 01:39
 */
@Service
public class LuckymoneyService {

	@Autowired
	private LuckmoneyRepository repository;

	/**
	 * 事务 指数据库事务
	 * 扣库存 > 创建订单
	 */
	@Transactional
	public void createTwo() {
		Luckymoney luckymoney1 = new Luckymoney();
		luckymoney1.setProducer("oracleOCM");
		luckymoney1.setMoney(new BigDecimal("520"));
		repository.save(luckymoney1);

		Luckymoney luckymoney2 = new Luckymoney();
		luckymoney2.setProducer("oracleOCM");
		luckymoney2.setMoney(new BigDecimal("1314"));
		repository.save(luckymoney2);
	}

	public void getMRange(Integer id) throws Exception{
		Optional<Luckymoney> optional =repository.findById(id);
		if (optional.isPresent()) {
			Luckymoney luckymoney = optional.get();
			BigDecimal momeny = luckymoney.getMoney();
			if(momeny.compareTo(new BigDecimal(2.00))==-1){
				//没使用枚举
				//throw  new AppException(1001,"红包太小了");
				throw new AppException(AppExceptionEnum.LOW_M);
			}else if(momeny.compareTo(new BigDecimal(2.00))==1 && momeny.compareTo(new BigDecimal(20.00)) ==-1 ){
				//没使用枚举
				//throw new AppException(1002,"还可以");
				throw new AppException(AppExceptionEnum.OK_M);
			}
		}
	}
}
