package co.micol.exam.member.service;

public interface MemberMapper {
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
}
