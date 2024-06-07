package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.RegionMapper;
import team1.project.vo.Region;

@Service
@Transactional
public class RegionService {
	
	@Autowired private RegionMapper regionMapper;
	
	public String selectRegionCode(String rMagjor, String rMinor) {
		return regionMapper.selectRegionCode(rMagjor, rMinor);
	}
	
	public List<Region> getRegionMinorList(String regionMajor) {
		return regionMapper.getRegionMinorList(regionMajor);
	}
	
	public List<Region> getSearchRegion(String sk, String sv){
		return regionMapper.getSearchRegion(sk, sv);
	}
	
	public int deleteRegion(Region region) {
		return regionMapper.deleteRegion(region);
	}
	
	public int modifyRegion(Region region) {
		return regionMapper.modifyRegion(region);
	}
	
	public Region getRegion(String regionCode) {
		
		return regionMapper.getRegion(regionCode);
	}
	
	public int addRegion(Region region) {
		return regionMapper.addRegion(region);
	}
	
	public List<Region> getRegionMajorList(){
		return regionMapper.getRegionMajorList();
	}
	
	public List<Region> getOfficeRegionList(){
		return regionMapper.getRegionList();
	}

}
