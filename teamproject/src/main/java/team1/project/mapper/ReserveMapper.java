package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.RtcanReserve;

@Mapper
public interface ReserveMapper {
	public List<RtcanReserve> getRtcanReserveTime();
	public List<RtcanReserve>getSearchRtcanReserve(String sk, String sv);
	public int deleteRtcanReserve(RtcanReserve rtcanReserve);
	public RtcanReserve getSelectRtcanReserve(String rtcanCode);
	public int getReserveCount();
	public List<RtcanReserve> getRtcanReserveList(String libraryCode);
	public int modifyRtcanReserve(RtcanReserve rtcanReserve);
	public List<RtcanReserve> addRtcanReserveList(String libraryCode);
	public int addRtcanReserve(RtcanReserve rtcanReserve);
	
}
