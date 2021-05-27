package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.domain.BaseballTeam;
import com.example.repository.BaseballTeamRepository;

@SpringBootTest
class BaseballTeamServiceTest {

	@Autowired
	private BaseballTeamRepository repository;

	@Test
	void test1() {
		System.out.println("全件表示するテスト開始");

		List<BaseballTeam> baseballTeamList = repository.findAll();

		assertEquals(6, baseballTeamList.size(), "件数が一致しません");
		assertEquals("読売ジャイアンツ", baseballTeamList.get(0).getTeamName(), "チーム名が発足日順の昇順で並び替えされていません");
		assertEquals("東京ヤクルトスワローズ", baseballTeamList.get(baseballTeamList.size() - 1).getTeamName(),
				"チーム名が発足日順の昇順で並び替えされていません");

		System.out.println("全件表示するテスト終了");
	}

	@Test
	void test2() {
		System.out.println("詳細表示するテスト開始");

		BaseballTeam baseballTeam = repository.load(1);

		assertEquals("読売ジャイアンツ", baseballTeam.getTeamName());
		assertEquals("東京ドーム（東京都・文京区）", baseballTeam.getHeadquarters());
		assertEquals("1934年12月26日", baseballTeam.getInauguration());

		System.out.println("詳細表示するテスト開始");
	}

}
