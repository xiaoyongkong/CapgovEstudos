package br.com.capgov.roupas.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

		HibernateUtil.getSessionfactory().close();
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		HibernateUtil.getSessionfactory().openSession();
		
	}


}
