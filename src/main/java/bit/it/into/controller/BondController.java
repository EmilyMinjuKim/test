package bit.it.into.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.it.into.dto.BondDto;
import bit.it.into.service.BondService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class BondController {
	final static Logger logger = LoggerFactory.getLogger(BondController.class);
	
	
	@Inject
	BondService bondService;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception {	
		logger.info("list");
		List<BondDto> getList = bondService.getList();
		model.addAttribute("list", getList);
		return "bond";
	}

	
}
