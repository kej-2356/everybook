package team1.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.CareerMapper;
import team1.project.vo.Career;

@Service
@Transactional
public class CareerService {
	@Autowired private CareerMapper careerMapper;
	
	public int addOfficerCareer(Career career) {
		return careerMapper.addOfficerCareer(career);
	}
}
