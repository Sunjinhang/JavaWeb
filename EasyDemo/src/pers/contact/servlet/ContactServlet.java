package pers.contact.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import pers.contact.entity.Contact;
import pers.contact.service.ContactService;
 
/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
        
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		
		ContactService ud = new ContactService();
		// 获得do属性
		String dos = request.getParameter("do");
		if (dos == null || dos.equals("")) {
			dos = "index";
		}
		// 主页
		if (dos.equals("index")) {
			List<Contact> ulist = ud.GetAllContact();
			request.setAttribute("ulist", ulist);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		if(dos.equals("add")) {
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String phone = request.getParameter("phone");
			
			
			String dates = request.getParameter("date");
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
			Date date = null;
			
			try {
				date = (Date)sdf.parse(dates);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//爱好获取
			String favorite = request.getParameter("favorite");
			
			Contact contact = new Contact(0,name,age,phone,date,favorite);
			
			ud.AddContact(contact);
			out.print("<script>alert('新增成功！');window.location='ContactServlet?do=index';</script>");				
		}
		
		if(dos.equals("del")) {
			
			String ids = request.getParameter("id");
			int id = Integer.parseInt(ids);
			ud.DeleteContact(id);
			out.print("<script>alert('删除成功！');window.location='ContactServlet?do=index';</script>");	
		}
		
		if(dos.equals("editbefore")) {
			int id =  Integer.parseInt(request.getParameter("id"));
			Contact f = ud.GetContact(id);
			session.setAttribute("edituser", f);
			response.sendRedirect("edit.jsp");
			return;
		}
		if(dos.equals("edit")) {
			try {
				
				int id = Integer.parseInt(request.getParameter("id"));
				
				String name = request.getParameter("name");
				int age = Integer.parseInt(request.getParameter("age"));
				String phone = request.getParameter("phone");
				
				
				String dates = request.getParameter("date");
				SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
				Date date = null;
				date = (Date)sdf.parse(dates);
				String favorite = request.getParameter("favorite");
				
				Contact contact = new Contact(id,name,age,phone,date,favorite);
				
				ud.UpdateContact(contact);
				out.print("<script>alert('修改成功！');window.location='ContactServlet?do=index';</script>");	
				
			}
			catch(ParseException ex) {
				
				ex.printStackTrace();
			}
			
		}
		
	}
 
}