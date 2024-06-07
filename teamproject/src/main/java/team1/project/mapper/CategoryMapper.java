package team1.project.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
	
	public String selectCategoryCode(String categoryNumber);

}
