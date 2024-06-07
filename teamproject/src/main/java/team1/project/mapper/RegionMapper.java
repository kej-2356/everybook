package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Region;

@Mapper
public interface RegionMapper {
	
	//지역코드 출력
	public String selectRegionCode(String rMagjor, String rMinor);
	
	public List<Region> getRegionMinorList(String regionMajor);
	
	public List<Region> getSearchRegion(String sk, String sv);
	
	public int deleteRegion(Region region);
	
	public int modifyRegion(Region region);
	
	public Region getRegion(String regionCode);
	
	public int addRegion(Region region);
	
	public List<Region> getRegionMajorList();
	
	public List<Region> getRegionList();
}
