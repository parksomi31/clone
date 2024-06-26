package kr.soft.study.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import kr.soft.study.dao.IDao;
import kr.soft.study.util.Constant;

public class BContentCommand implements BCommand {

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();// Model ��ü�� ����� ���� Map ���·� ��ȯ�մϴ�. (model��ü���� request�Ӹ��� �ƴ϶� �پ��� ������
												// �������)
		HttpServletRequest request = (HttpServletRequest) map.get("request"); // request�� �����ͼ� ����ȯ
		String bId = request.getParameter("bId");

		SqlSession sqlSession = Constant.sqlSession;
		IDao dao = sqlSession.getMapper(IDao.class);

		dao.upHit(bId);
		model.addAttribute("content_view", dao.contentView(bId));

	}

}
