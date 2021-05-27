package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.form.PriceForm;
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
	@Autowired
	private HotelService service;

	@ModelAttribute
	public PriceForm setUpForm() {
		return new PriceForm();
	}

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
	 * 値段以下のホテル一覧を表示する.<br>
	 * リクエストスコープのemptyHotelListMessageは検索ボタンを押していないときに"該当するホテルは存在しません"と表示されないようにするために用意。
	 * 
	 * @param price 値段
	 * @param model リクエストスコープ
	 * @return 検索画面のビュー
	 */
	@RequestMapping("/search-by-price")
	public String searchByPrice(@Validated PriceForm form, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return index(model);
		}

		List<Hotel> hotelList = service.showList(form.getPrice());

		if (hotelList.isEmpty()) {
			model.addAttribute("emptyHotelListMessage", "該当するホテルは存在しません");
		}
		model.addAttribute("hotelList", hotelList);

		return "forward:/ex02/";
	}
}
