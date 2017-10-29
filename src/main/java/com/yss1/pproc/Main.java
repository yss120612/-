package com.yss1.pproc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.itextpdf.text.DocumentException;
import com.yss1.pproc.util.Document1;
import com.yss1.pproc.util.Utils;


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Main extends SpringBootServletInitializer {

	private static Class<Main> applicationClass = Main.class;

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
		
		ApplicationContext ctx = SpringApplication.run(applicationClass, args);
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
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	@Bean
    public DataSource dataSource1(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/pproc");
        dataSource.setUsername( "userx" );
        dataSource.setPassword( "1111" );
        return dataSource;
    }
	
	
}
