package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.PointStandard;

@Mapper
public interface PointStandardMapper {
	
	public List<PointStandard> searchPs(String sk, String sv);
	
	public int deletePs(PointStandard point);
	
	public int modifyPs(PointStandard point);
	
	public PointStandard getSelectPs(String psCode);
	
	public int addPs(PointStandard point);
	
	public List<PointStandard> getPsList();

}
