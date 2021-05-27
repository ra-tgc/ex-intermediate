package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Clothing;

/**
 * clothesテーブルを操作するリポジトリ.
 * 
 * @author masaki.taguchi
 *
 */
@Repository
public class ClothingRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Clothing> CLOTHING_ROW_MAPPER = new BeanPropertyRowMapper<>(Clothing.class);

	/**
	 * 衣類情報を色と性別で検索する.
	 * 
	 * @param color  照合する色
	 * @param gender 照合する性別
	 * @return 衣類情報(ジャンルの昇順)
	 */
	public List<Clothing> findByColorAndGender(String color, Integer gender) {
		String sql = "SELECT id, category, genre, gender, color, price, size FROM clothes WHERE color = :color AND gender = :gender ORDER BY genre;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("color", color).addValue("gender", gender);
		List<Clothing> clothingList = template.query(sql, param, CLOTHING_ROW_MAPPER);

		return clothingList;

	}
}
