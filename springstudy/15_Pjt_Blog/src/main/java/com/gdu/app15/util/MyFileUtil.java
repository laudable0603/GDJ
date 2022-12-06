package com.gdu.app15.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;
import java.util.regex.Matcher;

import org.springframework.stereotype.Component;

@Component
public class MyFileUtil {

	// 파일명 : UUID값을 사용
	// 경로명 : 현재 날짜를 디렉터리로 생성해서 사용(날마다 폴더 생성)
	
	public String getFilename(String filename) {
		// 같은 디렉토리에 똑같은 파일을 업로드할 수 없기 때문에 파일이름을 임의로 바꾼다 (여러 사용자가 다른 이름을 사용할거란 보장 X)
		// 인코딩이 필요없어진다.
		// 원래 이름은 DB에 저장
		
		// 확장자 예외 처리 (리눅스대비 리눅스 경우 확장자 사이에 .(마침표)있을 수 있음)
		String extension = null;
		if(filename.endsWith("tar.gz")) {
			extension = "tar.gz";
		} else {
			
			// 파라미터로 전달된 filename의 확장자만 살려서 UUID 확장자 방식으로 반환
			String[] arr = filename.split("\\."); // 정규식에서 .(마침표)인식 : \. 또는 [.]
			
			//확장자
			extension = arr[arr.length - 1];
		}
		
		// UUID.확장자						UUID 기본값은 - 붙어 나온다. -을 공백으로 바꿧다.
		return UUID.randomUUID().toString().replaceAll("\\-", "") + "." + extension;
		
		
		
		
	}
	// 경로(오늘 날짜 폴더)
	public String getTodayPath() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		// File.separator = 윈도우 \ 리눅스/ 알아서 변경
		String sep = Matcher.quoteReplacement(File.separator);
		return "storage" + sep + year + sep + makeZero(month) + sep + makeZero(day);
		
	}
	
	// 경로(어제 날짜 폴더)
	public String getYesterDayPath() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1); // 1일 전
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		// File.separator = 윈도우 \ 리눅스/ 알아서 변경
		String sep = Matcher.quoteReplacement(File.separator);
		return "storage" + sep + year + sep + makeZero(month) + sep + makeZero(day);
		
	}
	
	// 1~9 => 01 ~ 09
	public String makeZero(int n) {
		return (n < 10) ? "0" + n : "" + n;
	}
	
	
}
