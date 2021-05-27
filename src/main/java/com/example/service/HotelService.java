package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * ホテル情報を操作するサービス.
 * 
 * @author masaki.taguchi
 *
 */
@Service
@Transactional
public class HotelService {
	@Autowired
	private HotelRepository repository;

	/**
	 * 値段以下のホテル情報を取得する.
	 * 
	 * @param price 値段
	 * @return 値段以下のホテル情報
	 */
	public List<Hotel> showList(Integer price) {

		return repository.searchByLessThanPrice(price);
	}

	/**
	 * ホテル情報を全件取得する(値段が存在しない場合).
	 * 
	 * @param price price 値段
	 * @return 全件取得
	 */
	public List<Hotel> showList(String price) {
		return repository.findAll();
	}
}
