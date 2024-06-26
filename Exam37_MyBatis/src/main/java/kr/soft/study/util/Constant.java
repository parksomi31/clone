package kr.soft.study.util;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.core.JdbcTemplate;

public class Constant {

	public static JdbcTemplate template; // 다른 패키지에서도 접근하려고 public사용한거고 다른데서도 공유해서 사용하려고 static을 사용
	public static SqlSession sqlSession;

}
