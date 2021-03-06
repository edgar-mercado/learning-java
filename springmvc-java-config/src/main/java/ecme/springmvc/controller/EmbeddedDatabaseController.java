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
public class EmbeddedDatabaseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmbeddedDatabaseController.class);
	
	@Autowired
	@Qualifier("dsEmbedded")
	DataSource dsEmbedded;
	
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value="/displayUsets")
	public String displayUsers(){
		jdbcTemplate= new JdbcTemplate(dsEmbedded);
		List<Map<String, Object>> usrList = jdbcTemplate.queryForList("Select * from user");
		for (Map<String, Object> map : usrList) {
			LOGGER.debug("------------> Username:"+map.get("username"));
		}
		return "index";
	}
}
