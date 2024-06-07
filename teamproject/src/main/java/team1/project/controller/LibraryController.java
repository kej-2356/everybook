package team1.project.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import team1.project.service.LibraryService;
import team1.project.service.RegionService;
import team1.project.vo.Library;
import team1.project.vo.Officer;
import team1.project.vo.Region;

@Controller
public class LibraryController {
	
	private final static Logger logger = LoggerFactory.getLogger(LibraryController.class);
	
	@Autowired private RegionService regionService;
	@Autowired private LibraryService libraryService;
	
	@GetMapping("/getLimitLibrarySearch")
	public String getLimitLibrarySearch(Model model, @RequestParam(value="sk") String sk, @RequestParam(value="sv") String sv) {
		logger.info("==== 도서관 검색 ===");
		Map<String, Object> returnMap = libraryService.getLimitLibrarySearch(sk, sv);
		model.addAttribute("list", returnMap.get("list"));
    	model.addAttribute("currentPage",returnMap.get("currentPage"));
    	model.addAttribute("lastPage",returnMap.get("lastPage"));
    	model.addAttribute("startPageNum",returnMap.get("startPageNum"));
    	model.addAttribute("lastPageNum", returnMap.get("lastPageNum"));
		return "information/libraryList";
	}
	
	@GetMapping("/libraryList")
	public String getLibraryList(Model model,@RequestParam(value="currentPage", 
			  									required=false, defaultValue="1") int currentPage) {
		Map<String, Object> returnMap = libraryService.getLimitLibraryList(currentPage);
		model.addAttribute("list", returnMap.get("list"));
    	model.addAttribute("currentPage",returnMap.get("currentPage"));
    	model.addAttribute("lastPage",returnMap.get("lastPage"));
    	model.addAttribute("startPageNum",returnMap.get("startPageNum"));
    	model.addAttribute("lastPageNum", returnMap.get("lastPageNum"));
		return "information/libraryList";
	}	
	
	@GetMapping("/searchLibrary")
	public String searchLibrary(Model model, @RequestParam("sk") String sk, @RequestParam("sv") String sv) {
		logger.info("==== 도서관 검색 ====");
		List<Library> libraryList = libraryService.searchLibrary(sk, sv);
		model.addAttribute("libraryList", libraryList);
		return "library/officeLibrary";
	}
	
	@PostMapping("/deleteLibrary")
	public String deleteLibrary(Library library) {
		logger.info("==== 도서관 삭제 ====");
		logger.info("deleteLibrary -{}",library.toString());
		int i = libraryService.deleteLibrary(library);
		logger.info("실행결과 : -{}",i);
		return "redirect:/officeLibrary";
	}
	
	@PostMapping("/modifyLibrary")
	public String modifyLibrary(Library library, Region region) {
		logger.info("==== 도서관 수정 ====");
		library.setRegion(region);
		logger.info("library -{}",library.toString());
		int i = libraryService.modifyLibrary(library);
		logger.info("실행경결과 : -{}",i);
		return "redirect:/officeLibrary";
	}
	
	@GetMapping(value="/getSelectLibrary")
	@ResponseBody
	public Library getSelectLibrary(@RequestParam("LibraryCode") String libraryCode) {
		logger.info("==== 하나 도서관 select ====");
		Library list = libraryService.getSelectLibrary(libraryCode);
		logger.info("librarylist-{}", list);
		return list;
	}
	
	@PostMapping("/addLibrary")
	public String addLibrary(Library library, Region region) {
		logger.info("==== 도서관 등록 ====");
		library.setRegion(region);
		logger.info(library.toString());
		int i = libraryService.addLibrary(library);
		logger.info("실행결과 : "+i);
		return "redirect:/officeLibrary";
	}
	
	@GetMapping(value="/getRegionMinorList")
	@ResponseBody
	public List<Region> getRegionMinorList(@RequestParam("regionMajor") String regionMajor) {
		logger.info(regionMajor + "  <-getRegionMinorList LibraryController.java");
		logger.info("========= getRegionMinorList LibraryController.java ============");
		List<Region> region = regionService.getRegionMinorList(regionMajor);
		logger.info(region.toString());
		 
		return region;
	}
	
	@GetMapping("/getSearchRegion")
	public String getSearchRegion(Model model, @RequestParam(value="sk") String sk
									,@RequestParam(value="sv") String sv) {
		System.out.println("========= getSearchRegion LibraryController.java ============");
		System.out.println(sk +" <- sk;  " + sv + " <- sv;");
		List<Region> regionList = regionService.getSearchRegion(sk, sv);
		model.addAttribute("regionList", regionList);
		return "library/officeRegion";
	}
	
	@PostMapping("/deleteRegion")
	public String deleteRegion(Region region, Officer officer) {
		System.out.println("========= deleteRegion LibraryController.java ============");
		region.setOfficer(officer);
		System.out.println(region.toString());
		System.out.println(region.getOfficer().getOfficerId());
		System.out.println(region.getOfficer().getOfficerPw());
		int i = regionService.deleteRegion(region);
		System.out.println("deleteRegion 실행 결과 : "+i);
		return "redirect:/officeRegion";
	}
	
	@GetMapping(value="/selectRegion")
	@ResponseBody
	public Region getRegion(@RequestParam("regionCode") String regionCode) {
		logger.info(regionCode + "  {}-getRegion LibraryController.java");
		logger.info("========= getRegion LibraryController.java ============");
		Region region = regionService.getRegion(regionCode);
		logger.info(region.toString());
		 
		return region;
	}
	
	@PostMapping("/modifyRegion")
	public String modifyRegion(Region region, Officer officer) {
		System.out.println("========= addRegion LibraryController.java ============");
		region.setOfficer(officer);
		System.out.println(region.toString());
		int i = regionService.modifyRegion(region);
		System.out.println("modifyRegion 실행결과 : "+i);
		return "redirect:/officeRegion";
	}
	
	@PostMapping("/addRegion")
	public String addRegion(Region region, Officer officer) {
		System.out.println("========= addRegion LibraryController.java ============");
		region.setOfficer(officer);
		System.out.println(region.toString());
		int i = regionService.addRegion(region);
		System.out.println("실행결과  " + i);
		return "redirect:/officeRegion";
	}
	
	@GetMapping("/officeLibrary")
	public String getOfficeLibraryList(Model model) {
		logger.info("==== 도서관 리스트 ====");
		List<Library> libraryList = libraryService.getLibraryList();
		List<Region> regionMajorList = regionService.getRegionMajorList();
		logger.info("리스트 출력-{}", libraryList);
		model.addAttribute("libraryList", libraryList);
		model.addAttribute("regionMajorList", regionMajorList);
		return "library/officeLibrary";
	}
	
	@GetMapping("/officeRegion")
	public String getOfficeRegionList(Model model) {
		System.out.println("========= getOfficeRegionList LibraryController.java ============");
		List<Region> regionList = regionService.getOfficeRegionList();
		List<Region> regionMajorList = regionService.getRegionMajorList();
		model.addAttribute("regionList", regionList);
		model.addAttribute("regionMajorList", regionMajorList);
		return "library/officeRegion";
	}
}
