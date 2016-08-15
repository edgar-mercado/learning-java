package ecme.springmvc.controller;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DatabaseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseController.class);
	
	@Autowired
	@Qualifier("mySqlDS")
	DataSource ds;
	
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value="/displayUsers")
	public String displayUsers(){
		LOGGER.debug("-------------------MYSQL-----------");
		jdbcTemplate= new JdbcTemplate(ds);
		List<Map<String, Object>> usrList = jdbcTemplate.queryForList("Select * from usermanual");
		for (Map<String, Object> map : usrList) {
			LOGGER.debug("------------> Username:"+map.get("username"));
		}
		return "index";
	}
}
