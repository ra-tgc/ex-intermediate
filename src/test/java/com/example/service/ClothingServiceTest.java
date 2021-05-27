package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.domain.Clothing;
import com.example.repository.ClothingRepository;

@SpringBootTest
class ClothingServiceTest {

	@Autowired
	private ClothingRepository repository;

	@Test
	void test() {
		System.out.println("検索開始");

		List<Clothing> clothingList = repository.findByColorAndGender("赤", 0);

		assertEquals(1, clothingList.size());
		assertEquals("ジャケット", clothingList.get(0).getGenre());
		assertEquals("S", clothingList.get(0).getSize());
		assertEquals(10000, clothingList.get(0).getPrice());

		System.out.println("検索終了");
	}

}
