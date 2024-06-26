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

@Controller // 이 클래스가 Spring MVC의 컨트롤러 역할
public class BController {

	BCommand command = null; // BCommand 인터페이스 타입의 참조변수를 선언

	private SqlSession sqlSession;

	@Autowired
	public BController(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		Constant.sqlSession = this.sqlSession;
	}


	@RequestMapping("/list") // "/list" 경로로 들어오는 HTTP 요청을 처리
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

		model.addAttribute("request", request); // model객체에 request변수에다가 request를 담음
		// request 변수는 사용자가 입력한 값을 포함하는 HttpServletRequest 객체를 의미합니다. 이 객체는 HTTP 요청에 대한
		// 모든 정보를 담고 있음
		// 사용자가 폼을 통해 입력한 데이터, 쿼리 파라미터, 세션 정보 등을 모두 포함
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
