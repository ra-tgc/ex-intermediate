package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Clothing;
import com.example.repository.ClothingRepository;

/**
 * 衣類情報を操作するサービス.
 * 
 * @author masaki.taguchi
 *
 */
@Service
@Transactional
public class ClothingService {
	@Autowired
	private ClothingRepository repository;

	/**
	 * 色と性別の一致する衣類情報一覧を取得する.
	 * 
	 * @param color  色
	 * @param gender 性別
	 * @return 衣類情報一覧(ジャンルの昇順)
	 */
	public List<Clothing> searchByColorAndGender(String color, Integer gender) {

		return repository.findByColorAndGender(color, gender);
	}
}
