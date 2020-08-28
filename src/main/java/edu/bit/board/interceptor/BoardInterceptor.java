package edu.bit.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.board.vo.UserVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class BoardInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception{
		
		log.info("preHandler ����");
		
		HttpSession session = request.getSession();
		
		UserVO user = (UserVO) session.getAttribute("user");
		
		if (user == null) {
			log.info("user�� null");
			//�α����� �� �Ǿ� �ִ� �����̹Ƿ� �α��� ������ �ٽ� ��������(redirect)
			response.sendRedirect(request.getContextPath());
			return false;	//�� �̻� ��Ʈ�ѷ� ��û���� ���� �ʵ��� false�� ��ȯ��
		}
		
		return true;
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception{
		
		super.postHandle(request, response, handler, modelAndView);
		log.info("postHandle ����");
	}
}

