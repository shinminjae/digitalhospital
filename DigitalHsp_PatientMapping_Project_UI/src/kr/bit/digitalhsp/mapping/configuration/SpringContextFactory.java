package kr.bit.digitalhsp.mapping.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextFactory {
	
	private static ApplicationContext ctx = null;
	
	private SpringContextFactory() {
		// TODO Auto-generated constructor stub
	}

	public synchronized static ApplicationContext getInstance()
	{
		if(ctx == null)
		{
			ctx = new ClassPathXmlApplicationContext("property/spring/servlet-context.xml");
		}
		return ctx;
	}
}
