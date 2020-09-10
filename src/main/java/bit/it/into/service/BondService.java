package bit.it.into.service;

import java.util.List;

import bit.it.into.dto.BondDto;

public interface BondService {

	public abstract List<BondDto> getList() throws Exception;

	public abstract void insertBond(BondDto bondDto);
		
	
}
