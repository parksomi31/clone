package kr.soft.study.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import kr.soft.study.dao.IDao;
import kr.soft.study.util.Constant;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// Model 객체에 저장된 값을 Map 형태로 변환합니다. (model객체에는 request뿐만이 아니라 다양한 값들이 담겨있음)
		Map<String, Object> map = model.asMap(); // field가 키가 되고 거기에 담긴 값이 value가 됨

		// Map에서 "request" 키에 해당하는 값을 가져와 HttpServletRequest로 캐스팅합니다.
		HttpServletRequest request = (HttpServletRequest) map.get("request"); // map안에 request가 키, value가 그 안에 담긴 값들이야

		// HttpServletRequest 객체에서 bName, bTitle, bContent 파라미터를 가져옵니다.
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");

		SqlSession sqlSession = Constant.sqlSession;
		IDao dao = sqlSession.getMapper(IDao.class);

		int maxcount = dao.writeBID();

		dao.write(maxcount, bName, bTitle, bContent, maxcount);

	}
}