package kr.soft.study.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import kr.soft.study.dao.IDao;
import kr.soft.study.util.Constant;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {

		// BDao dao = new BDao(); // BDao 객체를 생성. BDao는 데이터베이스와의 연동을 처리하는 클래스
		SqlSession sqlSession = Constant.sqlSession;
		IDao dao = sqlSession.getMapper(IDao.class);
		// ArrayList<BDto> dtos = dao.list(); // dao의 list() 메서드를 호출하여 게시물 목록을 가져옴. 이
		// 목록은 BDto 객체들의 ArrayList
		// model.addAttribute("list", dtos); // Model 객체에 "list"라는 이름으로 게시물 목록을 추가.
		// view페이지에서 보여지려면 model에 담아서 데이터를 넘겨야하니까
		model.addAttribute("list", dao.list());
	}

}
