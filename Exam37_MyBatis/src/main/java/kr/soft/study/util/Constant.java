package kr.soft.study.util;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.core.JdbcTemplate;

public class Constant {

	public static JdbcTemplate template; // �ٸ� ��Ű�������� �����Ϸ��� public����ѰŰ� �ٸ������� �����ؼ� ����Ϸ��� static�� ���
	public static SqlSession sqlSession;

}
