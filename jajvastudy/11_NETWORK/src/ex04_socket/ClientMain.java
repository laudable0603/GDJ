package ex04_socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {

		Socket clientSocket = null;

		try {

			// 소켓 생성 및 접근
			clientSocket = new Socket();

			// 서버 접속
			clientSocket.connect(new InetSocketAddress("localhost", 9099));

			// 서버에 접속되면 Welcome 메시지가 넘어옴
			// 서버가 DataOutputStream의 writeUTF로 메시지를 전송하므로
			// 클라이언트는 DataOutputStream의 writeUTF로 메시지를 받음
			DataInputStream in = new DataInputStream(clientSocket.getInputStream());
			String message = in.readUTF();
			System.out.println("[클라이언트] " + message);

			// 보내기

			Scanner sc = new Scanner(System.in);
			System.out.println("서버로 보낼 메시지를 입력해주세요 >>> ");
			String send = sc.nextLine();

			OutputStreamWriter out = new OutputStreamWriter(clientSocket.getOutputStream());
			out.write(send);

			// 입출력 스트림 종료
			out.close();
			in.close();
			sc.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (clientSocket.isClosed() == false) {
					System.out.println("[클라이언트] 클라이언트 종료");
					clientSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
