package com.ocm.bootApp.controller;

import com.ocm.bootApp.domain.Result;
import com.ocm.bootApp.repository.LuckmoneyRepository;
import com.ocm.bootApp.service.LuckymoneyService;
import com.ocm.bootApp.domain.Luckymoney;
import com.ocm.bootApp.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Created by oracleOCM
 * 2020-03-11 21:35
 */
@RestController
public class LuckymoneyController {

	@Autowired
	private LuckmoneyRepository repository;

	@Autowired
	private LuckymoneyService service;

	/**
	 * 获取红包列表
	 */
	@GetMapping("/luckymoneys")
	public List<Luckymoney> list() {
		return repository.findAll();
	}

	/**
	 * 创建红包(发红包)
	 * 单个参数接受写法
	 */
	@PostMapping("/luckymoneys")
	public Luckymoney create(@RequestParam("producer") String producer,
							 @RequestParam("money") BigDecimal money) {
		Luckymoney luckymoney = new Luckymoney();
		luckymoney.setProducer(producer);
		luckymoney.setMoney(money);
		return repository.save(luckymoney);
	}
	/**
	 * 接受对象
	 *新增数据
	 */
	@PostMapping("/luckMAdd_inite")
	public Luckymoney luckMAdd_inite(Luckymoney luckyM) {
		Luckymoney luckymoney = new Luckymoney();
		luckymoney.setProducer(luckyM.getProducer());
		luckymoney.setMoney(luckyM.getMoney());
		luckymoney.setConsumer(luckyM.getConsumer());
		return repository.save(luckymoney);
	}

	/**
	 * 接受对象
	 *新增数据
	 * @Valid  验证domain中设置最小值检验
	 */
	@PostMapping("/luckMAdd")
	public Luckymoney luckMAdd(@Valid Luckymoney luckyM, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			System.out.println(bindingResult.getFieldError().getDefaultMessage());
			return null ;
		}
		Luckymoney luckymoney = new Luckymoney();
		luckymoney.setProducer(luckyM.getProducer());
		luckymoney.setMoney(luckyM.getMoney());
		luckymoney.setConsumer(luckyM.getConsumer());
		return repository.save(luckymoney);
	}


	/**
	 * 接受对象
	 *新增数据
	 * @Valid  验证domain中设置最小值检验
	 * 统一封装返回数据类型
	 */
	@PostMapping("/luckMAdd_common")
	public Result luckMAdd_common(@Valid Luckymoney luckyM, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			//原始写法
			/*Result result = new Result();
			result.setCode(1);
			result.setMsg(bindingResult.getFieldError().getDefaultMessage());
			result.setData(null);*/
			//优化代码
			return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
		}
		Luckymoney luckymoney = new Luckymoney();
		luckymoney.setProducer(luckyM.getProducer());
		luckymoney.setMoney(luckyM.getMoney());
		luckymoney.setConsumer(luckyM.getConsumer());

		/*Result result  = new Result();
		result.setCode(0);
		result.setMsg("success");
		result.setData(repository.save(luckymoney));*/

		return ResultUtil.success(repository.save(luckymoney));
	}


	/**
	 * 通过id查询红包
	 */
	@GetMapping("/luckymoneys/{id}")
	public Luckymoney findById(@PathVariable("id") Integer id) {
		return repository.findById(id).orElse(null);
	}

	/**
	 * 更新红包(领红包)
	 */
	@PutMapping("/luckymoneys/{id}")
	public Luckymoney update(@PathVariable("id") Integer id,
							 @RequestParam("consumer") String consumer) {
		Optional<Luckymoney> optional = repository.findById(id);
		if (optional.isPresent()) {
			Luckymoney luckymoney = optional.get();
			luckymoney.setConsumer(consumer);
			return repository.save(luckymoney);
		}

		return null;
	}

	@PostMapping("/luckymoneys/two")
	public void createTwo() {
		service.createTwo();
	}

	/**
	 * 更新红包(领红包)
	 * 异常类处理
	 */
	@GetMapping("/getMRange/{id}")
	public void getMRange(@PathVariable("id") Integer id) throws Exception {
		service.getMRange(id);

	}

}
