package kr.soft.study.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.soft.study.command.BCommand;
import kr.soft.study.command.BContentCommand;
import kr.soft.study.command.BDeleteCommand;
import kr.soft.study.command.BListCommand;
import kr.soft.study.command.BModifyCommand;
import kr.soft.study.command.BReplyCommand;
import kr.soft.study.command.BReplyViewCommand;
import kr.soft.study.command.BWriteCommand;
import kr.soft.study.dao.IDao;
import kr.soft.study.util.Constant;

/**
 * Handles requests for the application home page.
 */

@Controller // �� Ŭ������ Spring MVC�� ��Ʈ�ѷ� ����
public class BController {

	BCommand command = null; // BCommand �������̽� Ÿ���� ���������� ����

	private SqlSession sqlSession;

	@Autowired
	public BController(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		Constant.sqlSession = this.sqlSession;
	}


	@RequestMapping("/list") // "/list" ��η� ������ HTTP ��û�� ó��
	public String list(Model model) {

		System.out.println("list()");
		command = new BListCommand();
		command.execute(model);

		return "list";
	}

	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		return "write_view";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");

		model.addAttribute("request", request); // model��ü�� request�������ٰ� request�� ����
		// request ������ ����ڰ� �Է��� ���� �����ϴ� HttpServletRequest ��ü�� �ǹ��մϴ�. �� ��ü�� HTTP ��û�� ����
		// ��� ������ ��� ����
		// ����ڰ� ���� ���� �Է��� ������, ���� �Ķ����, ���� ���� ���� ��� ����
		command = new BWriteCommand();
		command.execute(model);

		return "redirect:list";
	}

	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");

		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);

		return "content_view";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");

		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);

		return "redirect:list";
	}

	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");

		model.addAttribute("request", request);
		command = new BReplyViewCommand();
		command.execute(model);

		return "reply_view";
	}

	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");

		model.addAttribute("request", request);
		command = new BReplyCommand();
		command.execute(model);

		return "redirect:list";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");

		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);

		return "redirect:list";
	}

}
