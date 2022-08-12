package prac2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
	
	public static void q1 () {
		//eclipse-jee-2021-03-R-win32-x86_64.zip 복사하기
		// 복사할 파일명은 eclipse.zip
		File src = new File("c:\\GDJ\\installer","eclipse-jee-2021-03-R-win32-x86_64.zip");
		File cpy = new File("c:\\GDJ\\installer", "eclipse.zip");
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(cpy));
			
			byte[] b = new byte[1024]; //1KB
			int readByte = 0;
			
			long begin = System.currentTimeMillis();
			while((readByte = bis.read(b)) != -1) {
				bos.write(b, 0, readByte);
			}
			long end = System.currentTimeMillis();
			
			System.out.println("복사시간 : " + (end - begin) * 0.001 + "초");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bis != null) bis.close();
				if(bos != null) bos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}

	public static void q2() {
		
		
		
		
		//eclipse.zip 이동하기
		// 복사할 파일명은 eclipse.zip		
		File src = new File("c:\\GDJ\\installer", "eclipse.zip");
		File dir = new File("c:\\storage");
		
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File dst = new File("c:\\storage", src.getName());
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(dst));
			
			byte[] b = new byte[1024]; //1KB
			int readByte = 0;
			
			
			while((readByte = bis.read(b)) != -1) {
				bos.write(b, 0, readByte);
			}
			bos.close();
			bis.close();
			if(src.length() == dst.length()) {
					src.deleteOnExit();
			}
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		q2();
		
	}

}
