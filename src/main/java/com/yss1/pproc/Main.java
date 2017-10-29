package com.yss1.pproc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.itextpdf.text.DocumentException;
import com.yss1.pproc.util.Document1;
import com.yss1.pproc.util.Utils;



@SpringBootApplication
@EnableScheduling
public class Main  {

	
	private SheduledTask sheduledTask;
	private static Class<Main> applicationClass = Main.class;
	
	
	
	@PostConstruct
	public void init()
	{
		sheduledTask=new SheduleOne();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println(Utils.checkSNILS("174-672-541 96"));
//		System.out.println(Utils.checkSNILS("04688458613"));
//		System.out.println(Utils.getFormattedDate(new Date()));
//		System.out.println(String.format("%02x", 0));
		Document1 doc=new Document1();
		try {
			try {
				doc.makeDocument("Yss1");
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		SpringApplication.run(applicationClass, args);
//		String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
		
	}

	/*@Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        return factory;
    }*/
	
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(applicationClass);
//	}

	@Value("${application.db1.username}")
	String userPG;
	@Value("${application.db1.password}")
	String passPG;
	
	@Bean(name = "postgressDS")
    public DataSource dataSource1(){
		
		
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/pproc");
        
        dataSource.setUsername(userPG);
        dataSource.setPassword( passPG );
        return dataSource;
    }
	
	
	@Scheduled(fixedRate = 5000)
	public void task()
	{
		if (sheduledTask!=null) sheduledTask.run();
	}
	
}
