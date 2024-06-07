package team1.project.vo;

import java.util.List;
import java.util.Map;

public class Unicode {
	/*ㄱㄲㄴㄷㄸㄹㅁㅂㅃㅅㅆㅇㅈㅉㅊㅋㅌㅍㅎ */
	public static final char[] CHO =
		{0x3131, 0x3132, 0x3134, 0x3137, 0x3138, 0x3139, 0x3141, 0x3142, 0x3143, 0x3145,
		0x3146, 0x3147, 0x3148, 0x3149, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e};
	/*ㅏㅐㅑㅒㅓㅔㅕㅖㅗㅘㅙㅚㅛㅜㅝㅞㅟㅠㅡㅢㅣ*/
	public static final char[] JUN = 
	{0x314f, 0x3150, 0x3151, 0x3152, 0x3153, 0x3154, 0x3155, 0x3156, 0x3157, 0x3158,
		0x3159, 0x315a, 0x315b, 0x315c, 0x315d, 0x315e, 0x315f, 0x3160,	0x3161,	0x3162,
		0x3163};
	
	/*X ㄱㄲㄳㄴㄵㄶㄷㄹㄺㄻㄼㄽㄾㄿㅀㅁㅂㅄㅅㅆㅇㅈㅊㅋㅌㅍㅎ*/
	public static final char[] JON = 
	{0x0000, 0x3131, 0x3132, 0x3133, 0x3134, 0x3135, 0x3136, 0x3137, 0x3139, 0x313a,
		0x313b, 0x313c, 0x313d, 0x313e, 0x313f, 0x3140, 0x3141, 0x3142, 0x3144, 0x3145,
		0x3146, 0x3147, 0x3148, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e};
	

	public static String codeNum(List<Map<String, Character>> nameList) {
		String fir= "";
		String sec= "";
		Character text = nameList.get(1).get("reCho");
		if(text.equals('ㄱ')) {
			fir="1";
		}else if(text.equals('ㄴ')) {
			fir="19";
		}else if(text.equals('ㄷ') || text.equals('ㄸ')) {
			fir="2";
		}else if(text.equals('ㄹ')) {
			fir="29";
		}else if(text.equals('ㅁ')) {
			fir="3";
		}else if(text.equals('ㅂ') || text.equals('ㅃ')) {
			fir="4";
		}else if(text.equals('ㅅ') || text.equals('ㅆ')) {
			fir="5";
		}else if(text.equals('ㅇ')) {
			fir="6";
		}else if(text.equals('ㅈ') || text.equals('ㅉ')) {
			fir="7";
		}else if(text.equals('ㅊ')) {
			fir="8";
		}else if(text.equals('ㅋ')) {
			fir="87";
		}else if(text.equals('ㅌ')) {
			fir="88";
		}else if(text.equals('ㅍ')) {
			fir="89";
		}else if(text.equals('ㅎ')) {
			fir="9";
		}
		Character vo = nameList.get(1).get("reJun");
		if(fir.substring(0).equals("8")) {
			if(vo.equals('ㅏ') || vo.equals('ㅐ')|| vo.equals('ㅑ')|| vo.equals('ㅒ')) {
				sec="2";
			}else if(vo.equals('ㅓ') || vo.equals('ㅔ')|| vo.equals('ㅕ')|| vo.equals('ㅖ')) {
				sec="3";
			}else if(vo.equals('ㅗ') || vo.equals('ㅘ')|| vo.equals('ㅙ')|| vo.equals('ㅚ')|| vo.equals('ㅛ')) {
				sec="4";
			}else if(vo.equals('ㅜ') || vo.equals('ㅝ')|| vo.equals('ㅞ')|| vo.equals('ㅟ') || vo.equals('ㅠ') || vo.equals('ㅡ')|| vo.equals('ㅢ')) {
				sec="5";
			}else if(vo.equals('ㅣ')) {
				sec="6";
			}
		}else {
			if(vo.equals('ㅏ')) {
				sec="2";
			}else if(vo.equals('ㅐ')|| vo.equals('ㅑ')|| vo.equals('ㅒ')) {
				sec="3";
			}else if(vo.equals('ㅓ') || vo.equals('ㅔ')|| vo.equals('ㅕ')|| vo.equals('ㅖ')) {
				sec="4";
			}else if(vo.equals('ㅗ') || vo.equals('ㅘ')|| vo.equals('ㅙ')|| vo.equals('ㅚ')|| vo.equals('ㅛ')) {
				sec="5";
			}else if(vo.equals('ㅜ') || vo.equals('ㅝ')|| vo.equals('ㅞ')|| vo.equals('ㅟ') || vo.equals('ㅠ')) {
				sec="6";
			}else if(vo.equals('ㅡ')|| vo.equals('ㅢ')) {
				sec="7";
			}else if(vo.equals('ㅣ')) {
				sec="8";
			}
		}
		return fir+sec;
	}
}
