package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.BaseballTeam;

/**
 * teamsテーブルを操作するリポジトリ.
 * 
 * @author masaki.taguchi
 *
 */
@Repository
public class BaseballTeamRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<BaseballTeam> BASEBALLTEAM_ROW_MAPPER = new BeanPropertyRowMapper<>(
			BaseballTeam.class);

	/**
	 * チーム情報を全件取得する.
	 * 
	 * @return チーム情報全件
	 */
	public List<BaseballTeam> findAll() {
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams ORDER BY inauguration;";
		List<BaseballTeam> baseballTeamList = template.query(sql, BASEBALLTEAM_ROW_MAPPER);

		return baseballTeamList;
	}

	/**
	 * チーム情報を1件取得する.
	 * 
	 * @param id 主キー
	 * @return チーム情報1件
	 */
	public BaseballTeam load(Integer id) {
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams WHERE id = :id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		BaseballTeam baseballTeam = template.queryForObject(sql, param, BASEBALLTEAM_ROW_MAPPER);

		return baseballTeam;
	}

}
