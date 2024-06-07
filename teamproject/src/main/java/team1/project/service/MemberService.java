package team1.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.MemberMapper;
import team1.project.vo.Library;
import team1.project.vo.Member;

@Transactional
@Service
public class MemberService {

	@Autowired private MemberMapper memberMapper;
	
	public List<Member> officeListMember(String libraryCode){
		return memberMapper.officeListMember(libraryCode);
	}
	
	public int deleteMember(String memberId) {
		return memberMapper.deleteMember(memberId);
	};
	
	public Map<String, Object> getMemberAddress(String memberId) {
		return memberMapper.getMemberAddress(memberId);
	}
	
	public boolean selectCheckMemberId(String memberId) {
		return memberMapper.selectCheckMemberId(memberId);
	}
	
	public List<Member> allListMember(){
		return memberMapper.allListMember();
	}
	
	public int ModifyMember(Member member) {
		return memberMapper.ModifyMember(member);
	}
	
	public Member DetailMember(String memberId) {
		return memberMapper.DetailMember(memberId);
	};
	
	public Member selectgetMember(String memberId) {
		return memberMapper.selectgetMember(memberId);
	}
	
	public int addMember(Member member) {
		return memberMapper.addMember(member);
	};
}
