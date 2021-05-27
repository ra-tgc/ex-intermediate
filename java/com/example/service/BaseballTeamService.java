package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.BaseballTeam;
import com.example.repository.BaseballTeamRepository;

/**
 * チーム情報を操作するサービス.
 * 
 * @author masaki.taguchi
 *
 */
@Service
@Transactional
public class BaseballTeamService {

	@Autowired
	BaseballTeamRepository repository;

	/**
	 * チーム情報を全件取得する.
	 * 
	 * @return チーム情報全件
	 */
	public List<BaseballTeam> showList() {
		return repository.findAll();
	}

	/**
	 * チーム情報を1件取得する.
	 * 
	 * @param id 主キー
	 * @return チーム情報1件
	 */
	public BaseballTeam showDetail(Integer id) {
		return repository.load(id);
	}

}
