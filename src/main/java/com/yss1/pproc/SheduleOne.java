package com.yss1.pproc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;
import com.yss1.pproc.util.Document1;
import com.yss1.pproc.util.Utils;

@Service
@EnableScheduling
public class SheduleOne implements SheduledTask{
private int counter=0;

@Autowired private ApplicationContext applicationContext;


@Scheduled(fixedRate = 50000)
public void run()
{
	
	DataSource ds=(DataSource)applicationContext.getBean("postgressDS");
	Document1 doc=new Document1();
	String res="";
	try {
		res=Utils.bytes2HexStr(doc.makeDocument1(counter++));
//		ArrayList<Byte> alb = new ArrayList<Byte>();
//		for (byte b:barr)
//		{
//			
//		}
	} catch (DocumentException | IOException e) {
		e.printStackTrace();
	}
	if (ds!=null) {
    //JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
    
    //PreparedStatementCreator psc = (PreparedStatementCreator) new PreparedStatementCreatorFactory("update public.spravka set szi_new=? where id=1");
    
    System.out.println("Tut"+counter);
    try {
    //PreparedStatement pst=createPreparedStatement(ds.getConnection());
    PreparedStatement pst=ds.getConnection().prepareStatement("update public.spravka set szi_new=? where id=1");
    pst.setBinaryStream(1, new ByteArrayInputStream(res.getBytes()), res.length());
    pst.executeUpdate();
    pst.close();
    //jdbcTemplate.update("update public.spravka set szi_new=? where id=1", Utils.bytes2HexStr(barr));
    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	else
	{
		System.out.println("ds is null");
	}
}
	
}
