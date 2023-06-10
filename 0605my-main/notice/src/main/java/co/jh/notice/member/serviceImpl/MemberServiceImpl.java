package co.jh.notice.member.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.jh.notice.common.DataSource;
import co.jh.notice.member.service.MemberMapper;
import co.jh.notice.member.service.MemberService;
import co.jh.notice.member.service.MemberVO;

public class MemberServiceImpl implements MemberService {
	private SqlSession sqlSession=DataSource.getInstance().openSession(true);//auto commit을 위해 true를 넣음
	private MemberMapper map=sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public List<MemberVO> memberSelectList() {
		// TODO Auto-generated method stub
		return map.memberSelectList();
	}

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

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberUpdate(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberDelete(vo);
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberLogin(vo);
	}

}
