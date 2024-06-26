package kr.soft.study.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import kr.soft.study.dao.IDao;
import kr.soft.study.util.Constant;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {

		// BDao dao = new BDao(); // BDao ��ü�� ����. BDao�� �����ͺ��̽����� ������ ó���ϴ� Ŭ����
		SqlSession sqlSession = Constant.sqlSession;
		IDao dao = sqlSession.getMapper(IDao.class);
		// ArrayList<BDto> dtos = dao.list(); // dao�� list() �޼��带 ȣ���Ͽ� �Խù� ����� ������. ��
		// ����� BDto ��ü���� ArrayList
		// model.addAttribute("list", dtos); // Model ��ü�� "list"��� �̸����� �Խù� ����� �߰�.
		// view���������� ���������� model�� ��Ƽ� �����͸� �Ѱܾ��ϴϱ�
		model.addAttribute("list", dao.list());
	}

}
