package com.yss1.pproc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.yss1.pproc.util.Utils;

public class Main extends SpringBootServletInitializer {

	 private static Class<Main> applicationClass = Main.class;
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Man m=new Man();
		System.out.println(Utils.calcSNILS("174672541"));
		System.out.println(Utils.calcSNILS("046884586"));
		SpringApplication.run(applicationClass, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

	
}

