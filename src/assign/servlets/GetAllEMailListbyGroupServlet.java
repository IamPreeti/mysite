package assign.servlets;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailDBAccess;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/*
 * Get All Email Addresses by Group Servlet 
 */

public class GetAllEMailListbyGroupServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
	String errors = "";
	String groupID = "";
	//String groupID = request.getParameter("groupid");
	String emailID = request.getParameter("emailid");
        response.setContentType("text/html");
        System.out.println(emailID);

	EMailBO eMailBO = new EMailBO();
	ArrayList eMailAddress = null;

	try{
		groupID = eMailBO.getGroupByEmail(emailID);
		System.out.println(groupID);
	    eMailAddress = eMailBO.getAllEMailAddressListbyGroup(groupID);
	    for (Object o: eMailAddress) {
			System.out.println(o);
		}
	}catch (EMailValidationException emve){
		errors = emve.getErrorMessage();
	} 
	catch (Exception e){
		e.printStackTrace();
	}
	if (errors.equals("")){
		//request.getSession().setAttribute("emaillist", eMailAddress);	
		//response.sendRedirect("/mysite/viewbygroupsuccess.jsp");	
		request.setAttribute("emaillist", eMailAddress);
		RequestDispatcher rd = request.getRequestDispatcher("/viewallsuccess.jsp");
		rd.forward(request, response);

	}
	else {
		request.getSession().setAttribute("Errors", errors);
		response.sendRedirect("/mysite/error.jsp");
	}
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        doGet(request, response);
    }

}

