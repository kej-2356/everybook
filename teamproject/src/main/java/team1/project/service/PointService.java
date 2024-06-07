package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.PointHistoryMapper;
import team1.project.mapper.PointStandardMapper;
import team1.project.vo.PointHistory;
import team1.project.vo.PointStandard;

@Service
@Transactional
public class PointService {

	@Autowired private PointStandardMapper pointStandardMapper;
	@Autowired private PointHistoryMapper pointHistoryMapper;
	/*상벌점 내역*/
	public int addPh(PointHistory point) {
		String phCode = pointHistoryMapper.getMaxPhCode();
		if(phCode == null) {
			phCode = "point_history_00001";
		}else {
			phCode = phCode.substring(15);
			int maxPhCode = Integer.parseInt(phCode);
			if(maxPhCode <9) {
				phCode = "point_history_0000"+(maxPhCode+1);
			}else if(maxPhCode <99) {
				phCode = "point_history_000"+(maxPhCode+1);
			}else if(maxPhCode <999) {
				phCode = "point_history_00"+(maxPhCode+1);
			}else if(maxPhCode <999) {
				phCode = "point_history_0"+(maxPhCode+1);
			}else {
				phCode = "point_history_"+(maxPhCode+1);
			}
		}
		point.setPhCode(phCode);
		return pointHistoryMapper.addPh(point);
	}
	
	public List<PointHistory> getStandbyPsList(String libraryCode){
		return pointHistoryMapper.getStandbyPhList(libraryCode);
	}
	
	public List<PointHistory> getPhList(String libraryCode){
		return pointHistoryMapper.getPhList(libraryCode);
	}
	
	/*상벌점 기준*/
	public List<PointStandard> searchPs(String sk, String sv){
		return pointStandardMapper.searchPs(sk, sv);
	}
	
	public int deletePs(PointStandard point) {
		return pointStandardMapper.deletePs(point);
	}
	
	public int modifyPs(PointStandard point) {
		return pointStandardMapper.modifyPs(point);
	}
	
	public PointStandard getSelectPs(String psCode) {
		return pointStandardMapper.getSelectPs(psCode);
	}
	
	public int addPs(PointStandard point) {
		return pointStandardMapper.addPs(point);
	}
	
	public List<PointStandard> getPsList(){
		return pointStandardMapper.getPsList();
	}
	
}
