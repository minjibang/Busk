package com.busk.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.busk.action.Action;
import com.busk.action.ActionForward;

import com.busk.dao.MemberDao;
import com.busk.dto.member;

public class ProfileService implements Action {
	// 08.28민지 통채로 복사가능
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String type = (String) session.getAttribute("type");
		String adminemail = (String) session.getAttribute("adminemail");		
		System.out.println("email 값" + email + "adminemail값" + adminemail + "type 값" + type);
		try {
			MemberDao dao = new MemberDao();
			if (type.equals("2") || type.equals("3")) {
				ArrayList<member> memberinfo = dao.getMemberByEmail(email);
				request.setAttribute("memberinfo", memberinfo);
			} else {
				ArrayList<member> memberinfo = dao.getMemberByEmail(adminemail);
				request.setAttribute("memberinfo", memberinfo);

			}
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/menu/myProfile.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return forward;

	}
}
