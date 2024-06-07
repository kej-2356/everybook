package team1.project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Member;

@Mapper
public interface MemberMapper {

	/**
	 * 회원리스트(직원) - 직원과 같은 도서관 소속인 회원만
	 * */
	public List<Member> officeListMember(String libraryCode);
	
	//회원삭제
	public int deleteMember(String memberId);
	
	//주소 3개로 나눠서 출력
	public Map<String, Object> getMemberAddress(String memberId);
	
	//중복된 아이디 체크
	public boolean selectCheckMemberId(String memberId);
	
	//전체회원리스트
	public List<Member> allListMember();
	
	//회원수정
	public int ModifyMember(Member member);
	
	//회원상세보기
	public Member DetailMember(String memberId);
	
	//한명회원조회
	public Member selectgetMember(String memberId);
	
	//회원등록
	public int addMember(Member member);
}
