package kr.soft.study.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.core.JdbcTemplate;

import kr.soft.study.dto.BDto;
import kr.soft.study.util.Constant;

public interface IDao {

	public ArrayList<BDto> list();

	public int writeBID();

	public void write(int id, final String bName, final String bTitle, final String bContent, int id2);

	public BDto contentView(String strID);

	void upHit(final String bId);

	public void modify(final int bId, final String bName, final String bTitle, final String bContent);

	public BDto reply_view(String str);

	public void reply(final String bName, final String bTitle, final String bContent, final int bGroup, final int bStep,
			final int bIndent);

	void replyShape(final String strGroup, final String strStep);

	public void delete(final String bId);

}
