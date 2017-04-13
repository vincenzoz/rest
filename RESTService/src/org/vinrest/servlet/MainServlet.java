package org.vinrest.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.vinrest.beans.User;
import org.vinrest.utility.HibernateUtil;



/**
 * Servlet implementation class MainServlet
 */

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		
		String hql = "from users";
		TypedQuery<User> userList = session.createQuery(hql);
		List<User> result = userList.getResultList();
		System.out.println(result.get(0).toString());
		System.out.println(result.size());
		
		
		
		session.getTransaction();
		session.close();
		
		HibernateUtil.shutdown();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("2");
		doGet(request, response);
	}
}
