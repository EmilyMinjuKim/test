package bit.it.into.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import bit.it.into.dto.BondDto;

@Repository
public class BondDaoImpl implements BondDao { 
    
	@Inject
	SqlSession sqlSession;
	
	private static final String Namespace = "bit.it.into.mapper.BondMapper";

	@Override
	public List<BondDto> getList() throws Exception {
		return sqlSession.selectList(Namespace+".getList");
	}

	@Override
	public int insertBond(BondDto bondDto) {
		return sqlSession.insert(Namespace+".insertBond");
	}

	
}
