package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.PointHistory;

@Mapper
public interface PointHistoryMapper {
	
	public List<PointHistory> searchPh(String sk, String sv);
	
	public int deletePh(PointHistory point);
	
	public int modifyPh(PointHistory point);
	
	public PointHistory getSelectPh(String psCode);
	
	public String getMaxPhCode();
	
	public int addPh(PointHistory point);
	
	public List<PointHistory> getStandbyPhList(String libraryCode);
	
	public List<PointHistory> getPhList(String libraryCode);

}
