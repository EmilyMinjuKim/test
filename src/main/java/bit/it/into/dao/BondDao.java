package bit.it.into.dao;

import java.util.List;

import bit.it.into.dto.BondDto;

public interface BondDao {
	
	public List<BondDto> getList() throws Exception;

	public int insertBond(BondDto bondDto);
}
