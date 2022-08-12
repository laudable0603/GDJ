package oneday;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Paste {

	public static void main(String[] args) {
		
		File src = new File("c:\\GDJ\\installer", "FONT.zip" );
		File cpy = new File("c:\\storage", "Test.zip");
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			//src를 인풋스트림 하는데 버퍼드를 사용하겠다.
			bis =new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(cpy));
			
			//[] 바이트 단위로 [n]바이트 옮기겠다.
			byte[] b = new byte[100];
			
			int readByte = 0;
			
			while((readByte = bis.read(b)) != -1) {
				bos.write(b, 0, readByte);
			}
			bos.close();
			bis.close();
			if(src.length() == cpy.length()) {
				src.deleteOnExit();
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) bis.close();
				if (bos != null) bos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
	}

}
