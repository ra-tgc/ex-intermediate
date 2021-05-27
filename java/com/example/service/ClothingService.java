package com.example.service;

import java.util.ArrayList;
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
	 * 色と性別の一致する衣類情報一覧を取得する. <br>
	 * 直接URLが打ち込まれて色と性別のいずれかがnullの場合には空のリストを返す。
	 * 
	 * @param color  色
	 * @param gender 性別
	 * @return 衣類情報一覧(ジャンルの昇順)
	 */
	public List<Clothing> searchByColorAndGender(String color, String gender) {
		if (color == null || gender == null) {
			// 直接URLを打ち込んだ場合には空のリストを返す
			return new ArrayList<Clothing>();
		}

		try {
			return repository.findByColorAndGender(color, Integer.parseInt(gender));
		} catch (Exception e) {
			// 不正に値を書き換えられた際に空のリストを返す
			e.printStackTrace();
			return new ArrayList<Clothing>();
		}
	}
}
