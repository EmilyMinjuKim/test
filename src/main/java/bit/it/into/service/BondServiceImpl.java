package bit.it.into.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import bit.it.into.dao.BondDao;
import bit.it.into.dto.BondDto;

@Service
public class BondServiceImpl implements BondService {
	
	@Inject
	private BondDao dao;

	@Override
	public List<BondDto> getList() throws Exception {
		return dao.getList();
	}

	@Override
	public void insertBond(BondDto bondDto) {
		dao.insertBond(bondDto);
	}
	
	
}
