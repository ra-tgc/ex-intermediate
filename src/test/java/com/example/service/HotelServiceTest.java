package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

@SpringBootTest
class HotelServiceTest {

	@Autowired
	private HotelRepository repository;

	@Test
	void test1() {
		System.out.println("全件検索開始");

		List<Hotel> hotelList = repository.findAll();

		assertEquals(5, hotelList.size());

		System.out.println("全件検索終了");
	}

	@Test
	void test2() {
		System.out.println("値段検索開始");

		List<Hotel> hotelList = repository.findByLessThanPrice(10000);

		assertEquals(3, hotelList.size());

		System.out.println("値段検索終了");
	}

	@Test
	void test3() {
		System.out.println("値段検索開始");

		List<Hotel> hotelList = repository.findByLessThanPrice(5000);

		assertEquals(1, hotelList.size());
		assertEquals(5000, hotelList.get(0).getPrice());
		assertEquals("ホテルローズガーデン新宿", hotelList.get(0).getHotelName());
		assertEquals("西新宿駅", hotelList.get(0).getNearestStation());

		System.out.println("値段検索終了");
	}

}
