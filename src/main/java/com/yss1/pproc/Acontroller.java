package com.yss1.pproc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Acontroller {
	
	@Autowired private ApplicationContext applicationContext;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	 
	@RequestMapping(value="/idx2", method=RequestMethod.GET)
	public String showForm(Model model) {
																	   
//		DataSource ds= (DataSource) applicationContext.getBean("postgressDS");
//		 JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
//		 List<String> results = jdbcTemplate.query("select name from first", new RowMapper<String>() {
//             @Override
//             public String mapRow(ResultSet rs, int rowNum) throws SQLException {
//                 return new String(rs.getString("name"));
//             }
//         });
//		model.addAttribute("name",results.get(1));
	//	model.addAttribute("fam","Family Market");
		
		return "index2" ;
	}
	
	@RequestMapping(value="/idx2", method=RequestMethod.POST)
	public String resForm(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "index2";
	}
	
}
