package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BaseballTeam;
import com.example.service.BaseballTeamService;

/**
 * チーム関連機能の制御を行うコントローラ.
 * 
 * @author masaki.taguchi
 *
 */
@Controller
@RequestMapping("/ex01")
public class BaseballTeamController {
	@Autowired
	private BaseballTeamService service;

	/**
	 * チーム一覧画面を表示.
	 * 
	 * @param model リクエストスコープ
	 * @return チーム一覧画面のビュー
	 */
	@RequestMapping("/")
	public String index(Model model) {
		List<BaseballTeam> teamList = service.showList();

		model.addAttribute("teamList", teamList);
		return "baseballteam/list";
	}

	/**
	 * チーム詳細画面を表示.
	 * 
	 * @param id    リクエストパラメータ
	 * @param model リクエストスコープ
	 * @return チーム詳細画面のビュー
	 */
	@RequestMapping("/show-team-detail")
	public String showTeamDetail(String id, Model model) {
		BaseballTeam team = service.showDetail(Integer.parseInt(id));

		model.addAttribute("team", team);

		return "baseballteam/detail";
	}
}
