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

		Map<String, Object> map = model.asMap();// Model 객체에 저장된 값을 Map 형태로 변환합니다. (model객체에는 request뿐만이 아니라 다양한 값들이
												// 담겨있음)
		HttpServletRequest request = (HttpServletRequest) map.get("request"); // request를 꺼내와서 형변환
		String bId = request.getParameter("bId");

		SqlSession sqlSession = Constant.sqlSession;
		IDao dao = sqlSession.getMapper(IDao.class);

		dao.upHit(bId);
		model.addAttribute("content_view", dao.contentView(bId));

	}

}
