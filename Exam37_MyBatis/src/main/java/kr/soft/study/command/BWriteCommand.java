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
		// Model ��ü�� ����� ���� Map ���·� ��ȯ�մϴ�. (model��ü���� request�Ӹ��� �ƴ϶� �پ��� ������ �������)
		Map<String, Object> map = model.asMap(); // field�� Ű�� �ǰ� �ű⿡ ��� ���� value�� ��

		// Map���� "request" Ű�� �ش��ϴ� ���� ������ HttpServletRequest�� ĳ�����մϴ�.
		HttpServletRequest request = (HttpServletRequest) map.get("request"); // map�ȿ� request�� Ű, value�� �� �ȿ� ��� �����̾�

		// HttpServletRequest ��ü���� bName, bTitle, bContent �Ķ���͸� �����ɴϴ�.
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");

		SqlSession sqlSession = Constant.sqlSession;
		IDao dao = sqlSession.getMapper(IDao.class);

		int maxcount = dao.writeBID();

		dao.write(maxcount, bName, bTitle, bContent, maxcount);

	}
}