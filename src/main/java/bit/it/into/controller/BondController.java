package bit.it.into.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping("/list")
	public String list(Model model) throws Exception {	
		log.info("list");
		List<BondDto> getList = bondService.getList();
		model.addAttribute("list", getList);
		return "bond";
	}

	@RequestMapping(value="/insert", method= {RequestMethod.POST})
	public String insert(BondDto bondDto) throws Exception {
		log.info("insert()");
		
		bondService.insertBond(bondDto);
		
		return "redirect:bond";
	}
}
