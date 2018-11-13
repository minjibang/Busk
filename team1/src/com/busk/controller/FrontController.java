package com.busk.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.busk.action.Action;
import com.busk.action.ActionForward;
import com.busk.service.AddminHireListService;
import com.busk.service.AdminDeleteService;
import com.busk.service.AdminFanService;
import com.busk.service.AdminPageService;
import com.busk.service.ApplyService;
import com.busk.service.BuskerPageService;
import com.busk.service.BuskerSearchService;
import com.busk.service.BuskersService;
import com.busk.service.BuskingApplyService;
import com.busk.service.BuskingWangService;
import com.busk.service.CommunityBoardService;
import com.busk.service.CommunityDeleteService;
import com.busk.service.CommunityDetailService;
import com.busk.service.CommunityUpdateService;
import com.busk.service.CommunityUpdateSubmitService;
import com.busk.service.CommunityWriteService;
import com.busk.service.EmailjbService;
import com.busk.service.FanCountService;
import com.busk.service.FanDeleteService;
import com.busk.service.FanPageService;
import com.busk.service.FannoteDeleteService;
import com.busk.service.FannoteService;
import com.busk.service.FannoteSettingService;
import com.busk.service.GalleryDeleteService;
import com.busk.service.GalleryInsertService;
import com.busk.service.HireDeleteService;
import com.busk.service.HireInsertService;
import com.busk.service.HireListService;
import com.busk.service.HireService;
import com.busk.service.IngiWangService;
import com.busk.service.JoinService;
import com.busk.service.LeaveService;
import com.busk.service.LoginService;
import com.busk.service.MainPageService;
import com.busk.service.MyBuskerPageService;
import com.busk.service.ProfileModalService;
import com.busk.service.ProfilePwdCheckService;
import com.busk.service.ProfileService;
import com.busk.service.ProfileUpdateService;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.busk")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String RequestURI = request.getRequestURI();
		String ContextPath = request.getContextPath();
		String url_command = RequestURI.substring(ContextPath.length());
		String email = RequestURI.substring(ContextPath.length() + 1, RequestURI.lastIndexOf("."));
		System.out.println(email);
		Action action = null;
		ActionForward forward = null;
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if (url_command.equals("/main.busk")) {
			try {
				action = new MainPageService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_command.equals("/logout.busk")) {
			session.invalidate();
			out.print("logout");

		} else if (url_command.equals("/leave.busk")) {
			try {
				action = new LeaveService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (url_command.equals("/about.busk")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/menu/about.jsp");
		} else if (url_command.equals("/buskers.busk")) {
			try {
				action = new BuskersService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_command.equals("/hiredelete.busk")) {
			try {
				action = new HireDeleteService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} // 08.26민지 추가
		}else if (url_command.equals("/adminhirelist.busk")) {
			try {
				action = new AddminHireListService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_command.equals("/buskingapply.busk")) {
			try {
				action = new BuskingApplyService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_command.equals("/adminfanlist.busk")) {
			try {
				action = new AdminFanService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_command.equals("/adminfandelete.busk")) {
			try {
				action = new FanDeleteService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} // 08.26민지 추가 끝
		}  else if (url_command.equals("/community.busk")) {
			
			try {
				action = new CommunityBoardService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				action = new IngiWangService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				action = new BuskingWangService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (url_command.equals("/profilemodal.busk")) {
			try {
				action = new ProfileModalService();
				forward = action.execute(request, response); 
			} catch(Exception e) {
				e.printStackTrace(); 
			}
		}else if (url_command.equals("/fanpage.busk")) {  
			try {
				action = new  FanPageService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
//08.27민지 추가 끝
		}else if (url_command.equals("/adminpage.busk")) {  
			try {
				action = new AdminPageService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (url_command.equals("/admindeletepage.busk")) {  
			try {
				action = new AdminDeleteService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//민지추가 끝
		}  else if (url_command.equals("/community.busk")) {
			try {
				action = new CommunityBoardService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (url_command.equals("/writearticle.busk")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/menu/communityWrite.jsp");

		} else if (url_command.equals("/communitywrite.busk")) {
			try {
				action = new CommunityWriteService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (url_command.equals("/communityarticle.busk")) {
			try {
				action = new CommunityDetailService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_command.equals("/communityupdate.busk")) {
			try {
				action = new CommunityUpdateService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (url_command.equals("/communitydelete.busk")) {
			try {
				action = new CommunityDeleteService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (url_command.equals("/updatesubmit.busk")) {
			try {
				action = new CommunityUpdateSubmitService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_command.equals("/hire.busk")) {
			try {
				action = new HireService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_command.equals("/inserthire.busk")) {
			try {
				action = new HireInsertService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_command.equals("/hirelist.busk")) {
			try {
				action = new HireListService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (url_command.equals("/apply.busk")) {
			try {
				action = new ApplyService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_command.equals("/profile.busk")) {
			try {
				action = new ProfileService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_command.equals("/profileupdate.busk")) {
			try {
				action = new ProfileUpdateService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_command.equals("/updatepwdchk.busk")) {
			try {

				action = new ProfilePwdCheckService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (url_command.equals("/galleryinsert.busk")) {
			try {

				action = new GalleryInsertService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (url_command.equals("/gallerydelete.busk")) {
			try {
				action = new GalleryDeleteService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_command.equals("/message.busk")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/menu/message.jsp");
		} else if (url_command.equals("/fan.busk")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/menu/fanPage.jsp");
		} else if (url_command.equals("/join.busk")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/menu/join.jsp");
		} else if (url_command.equals("/joinconfirm.busk")) {
			try {
				action = new JoinService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_command.equals("/login.busk")) {
			try {
				action = new LoginService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_command.equals("/emailConfirm.busk")) {
			try {
				String BuskerMail = request.getParameter("email");
				session.setAttribute("mail", BuskerMail);
				out.print(BuskerMail);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (url_command.equals("/adminConfirm.busk")) {
			try {
				String adminemail = request.getParameter("email");
				System.out.println("controller에서 받은 email 값 : " + adminemail);
				session.setAttribute("adminemail", adminemail);
				out.print(adminemail);
			} catch (Exception e) {
				e.printStackTrace();
			}//08.28민지추가 끝
		} else if (url_command.equals("/emailjb.busk")) {
			try {
				action = new EmailjbService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_command.equals("/mybuskerPage.busk")) {
			try {
				String buskerEmail = (String) session.getAttribute("email");
				request.setAttribute("email", buskerEmail);
				action = new MyBuskerPageService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (url_command.equals("/buskerPage.busk")) {
			try {
				String buskerEmail = (String) session.getAttribute("mail");
				request.setAttribute("email", buskerEmail);
				action = new BuskerPageService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(url_command.equals("/fanCount.busk")) {
			
			try {
				  String fanEmail = (String) session.getAttribute("mail");
				  String myEmail = (String) session.getAttribute("email");
				  request.setAttribute("fanEmail", fanEmail);
				  request.setAttribute("myEmail", myEmail);
				  action = new FanCountService();
				  forward = action.execute(request, response);
				  
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(url_command.equals("/fannoteSetting.busk")) {
			try {
				  String myEmail = (String) session.getAttribute("email");
				  String fanEmail = (String) session.getAttribute("mail");
				  System.out.println("작성자는 " + myEmail + "이고 작성될 페이지의 주인 이메일은 " + fanEmail + "이다");
				  action = new FannoteSettingService();
				  forward = action.execute(request, response);
				  System.out.println(request + "//" + response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(url_command.equals("/fannoteAdd.busk")) {
			try {
				  String myEmail = (String) session.getAttribute("email");
				  String fanEmail = (String) session.getAttribute("mail");
				  String comment = (String) request.getParameter("fannote_content");
				  System.out.println("작성자는 " + myEmail + "이고 작성될 페이지의 주인 이메일은 " + fanEmail + "이고 내용은 " + comment);
				  action = new FannoteService();
				  forward = action.execute(request, response);
				  System.out.println(request + "//" + response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(url_command.equals("/fannoteDelete.busk")) {
			try {
				  String myEmail = (String) session.getAttribute("email");
				  String fanEmail = (String) session.getAttribute("mail");
				  String comment = (String) request.getParameter("fannote_content");
				  System.out.println("작성자는 " + myEmail + "이고 작성될 페이지의 주인 이메일은 " + fanEmail + "이고 내용은 " + comment);
				  action = new FannoteDeleteService();
				  forward = action.execute(request, response);
				  System.out.println(request + "//" + response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(url_command.equals("/buskersSearch.busk")) {
			try {
				  action = new BuskerSearchService();
				  forward = action.execute(request, response);
				  System.out.println(request + "//" + response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (forward != null) {
			if (forward.isRedirect()) { // true
				response.sendRedirect(forward.getPath()); // location.href
			} else {
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}

	}

}
