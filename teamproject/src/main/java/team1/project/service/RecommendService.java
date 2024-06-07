package team1.project.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team1.project.mapper.BookMapper;
import team1.project.mapper.LibraryMapper;
import team1.project.mapper.RentMapper;
import team1.project.vo.Book;

@Service
public class RecommendService {
	
	private final static Logger logger = LoggerFactory.getLogger(RecommendService.class);
	@Autowired LibraryMapper libraryMapper;
	@Autowired RentMapper rentMapper;
	@Autowired BookMapper bookMapper;
	
	public List<String> recommendList(String memberId){
		List<String> bookIsbn = rentMapper.selectIsbn(memberId);
		String uri = "http://data4library.kr/api/recommandList?authKey=d30acf5969608e57f856c36ddd03e661e138d851efb484a2ddffc33ce70627d4"
				+ "&isbn13=";
		String line = null;
		List<String> isbnList = new ArrayList<String>();
		for(int i =0; i < bookIsbn.size(); i++) {
			uri += bookIsbn.get(i)+";";
		}
		uri += "&format=json";
		logger.info("uri : {}",uri);
		try {
			URL url = new URL(uri);
			URLConnection conn = url.openConnection();
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			
			line = br.readLine();
			
			JSONParser parser = new JSONParser();
			JSONObject obj =  (JSONObject) parser.parse(line);
			JSONObject response = (JSONObject) obj.get("response");
			JSONArray docs =  (JSONArray) response.get("docs");
			//JSONObject books = (JSONObject) docs.get(0);
			
			//logger.info("books : {}",books.get("book"));
			//JSONObject isbn= null;
			
			for(int i=0; i < 100;i++) {
				JSONObject books = (JSONObject) docs.get(i);
				JSONObject book = (JSONObject) books.get("book");
				String isbn13 = (String) book.get("isbn13");
				if(isbn13 != null) {
					isbnList.add(isbn13);
				}
				//logger.info("isbn {}",isbn13);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		logger.info("isbnList : {}",isbnList);
		return isbnList;
	}
}
