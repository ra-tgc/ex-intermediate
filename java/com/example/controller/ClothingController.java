package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Clothing;
import com.example.service.ClothingService;

/**
 * 衣類関連機能の制御を行うコントローラ.
 * 
 * @author masaki.taguchi
 *
 */
@Controller
@RequestMapping("/ex03")
public class ClothingController {
	@Autowired
	private ClothingService service;

	/**
	 * 検索画面を表示する.<br>
	 * 選択肢の準備もここで行う。
	 * 
	 * @param model リクエストスコープ
	 * @return 検索画面のビュー
	 */
	@RequestMapping("/")
	public String index(Model model) {
		Map<Integer, String> genderMap = new HashMap<>();
		List<String> colorList = new ArrayList<>();

		genderMap.put(0, "Man");
		genderMap.put(1, "Woman");

		colorList.add("赤");
		colorList.add("青");
		colorList.add("白");
		colorList.add("黄");

		model.addAttribute("genderMap", genderMap);
		model.addAttribute("colorList", colorList);

		return "clothing/index";
	}

	/**
	 * 色と性別が一致する衣類情報を表示する.<br>
	 * リクエストスコープのemptyClothingListMessageは検索ボタンを押していないとき"該当する衣類は存在しません"と表示されないようにするために用意。
	 * genderが書き換えられて不正な値になっていた場合も同様の表示。
	 * 
	 * @param color  色
	 * @param gender 性別
	 * @param model  リクエストスコープ
	 * @return 検索画面のビュー
	 */
	@RequestMapping("/search-by-color-and-gender")
	public String searchByColorAndGender(String color, String gender, Model model) {

		if (!"0".equals(gender) && !"1".equals(gender)) {
			model.addAttribute("emptyClothingListMessage", "該当する衣類は存在しません");

			return "forward:/ex03/";
		}

		List<Clothing> clothingList = service.searchByColorAndGender(color, Integer.parseInt(gender));

		if (clothingList.isEmpty()) {
			model.addAttribute("emptyClothingListMessage", "該当する衣類は存在しません");
		}
		model.addAttribute("clothingList", clothingList);

		return "forward:/ex03/";
	}
}
