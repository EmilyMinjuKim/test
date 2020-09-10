package bit.it.into.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bit.it.into.dto.BondDto;
import bit.it.into.service.BondService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@AllArgsConstructor
public class ResfulController {

	@Inject
	BondService bondService;
	
	@RequestMapping("/restful/list")
	public List<BondDto> rest() throws Exception{
		List<BondDto> list =bondService.getList();
		
		return list;
	}
	
	@RequestMapping(value="/restful/insert", method=RequestMethod.POST)
	@ResponseBody
	public String insert(BondDto bondDto) throws Exception {
		//log.info("insert()");
		
		bondService.insertBond(bondDto);
		
		return "redirect:list";
	}
	
}
