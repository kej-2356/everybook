package team1.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Career;

@Mapper
public interface CareerMapper {

	public int addOfficerCareer(Career career);
}
