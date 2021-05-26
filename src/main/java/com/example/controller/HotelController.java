package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.service.HotelService;

/**
 * ホテル関連機能の制御を行うコントローラ.
 * 
 * @author masaki.taguchi
 *
 */
@Controller
@RequestMapping("/ex02")
public class HotelController {

	private HotelService service;

	/**
	 * 検索画面を表示する.
	 * 
	 * @param model リクエストスコープ
	 * @return 検索画面のビュー
	 */
	@RequestMapping("/")
	public String index(Model model) {
		return "hotel/index";
	}

	/**
	 * 値段以下のホテル一覧を表示する.
	 * 
	 * @param price 値段
	 * @param model リクエストスコープ
	 * @return 検索画面のビュー
	 */
	@RequestMapping("/search-by-price")
	public String searchByPrice(String price, Model model) {
		List<Hotel> hotelList = service.showList(Integer.parseInt(price));
		model.addAttribute("hotelList", hotelList);

		return "forward:/ex02/";
	}
}
