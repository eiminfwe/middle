package co.micol.exam.member.service.Impl;

import org.apache.ibatis.session.SqlSession;

import co.micol.exam.common.DataSource;
import co.micol.exam.member.service.MemberMapper;
import co.micol.exam.member.service.MemberService;
import co.micol.exam.member.service.MemberVO;

public class MemberServiceImpl implements MemberService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberInsert(vo);
	}

}
