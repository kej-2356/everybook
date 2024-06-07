package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.ReserveMapper;
import team1.project.vo.RtcanReserve;

@Service
@Transactional
public class RtcanReserveService {
	
	@Autowired private ReserveMapper reserveMapper;
	
	//예약 시간 조회 리스트
	public List<RtcanReserve> getRtcanReserveTime(){
		return reserveMapper.getRtcanReserveTime();
	}
	
	//조건에 따른 검색 리스트
	public List<RtcanReserve>getSearchRtcanReserve(String sk, String sv){
		return reserveMapper.getSearchRtcanReserve(sk, sv);
	}
	
	//삭제 버튼 클릭시 삭제 
	public int deleteRtcanReserve(RtcanReserve rtcanReserve) {
		return reserveMapper.deleteRtcanReserve(rtcanReserve);
	}
	
	
	//예약 코드로 하나의 예약 조회
	public RtcanReserve getSelectRtcanReserve(String rtcanCode) {
		return reserveMapper.getSelectRtcanReserve(rtcanCode);
	}
	
	//직원 온라인 예약 미승인 건수
	public int getReserveCount() {
		return reserveMapper.getReserveCount();
	}
	
	//직원 온라인 예약 리스트 화면 리스트 호출
	public List<RtcanReserve> getRtcanReserveList(String libraryCode){
		return reserveMapper.getRtcanReserveList(libraryCode);
	}
	
	//직원 온라인 예약  업데이트
	public int modifyRtcanReserve(RtcanReserve rtcanReserve) {
		return reserveMapper.modifyRtcanReserve(rtcanReserve);
	}
	
	//직원화면에서 회원이 등록한 대기중인 온라인 예약 리스트 호출
	public List<RtcanReserve> addRtcanReserveList(String libraryCode){
		return reserveMapper.addRtcanReserveList(libraryCode);
	}
	
	
	//회원 화면에서 회원이 온라인 예약 등록하기
	public int addRtcanReserve(RtcanReserve rtcanReserve) {
		return reserveMapper.addRtcanReserve(rtcanReserve);
	}
}
