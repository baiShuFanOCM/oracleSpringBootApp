package com.ocm.bootApp.controller;

import com.ocm.bootApp.domain.Luckymoney;
import com.ocm.bootApp.repository.LuckmoneyRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc   //测试controller，发送请求
public class LuckymoneyControllerTest {
    @Autowired
    private LuckmoneyRepository repository;

    @Autowired
    private MockMvc  mockMvc ;
    /**
     * 测试controller
     */
    @Test
    public void list() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/luckymoneys"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(MockMvcResultMatchers.content().string("abc"))
                .andExpect(MockMvcResultMatchers.content().encoding("UTF-8"));
    }

    /**
     * 测试service
     */
    @Test
    public void findById() {
        Optional<Luckymoney> optional = repository.findById(9);
        Assert.assertEquals(new BigDecimal(33).setScale(2),optional.get().getMoney());
        System.out.println(new BigDecimal(33).setScale(2));
    }
}
