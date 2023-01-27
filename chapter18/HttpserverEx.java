package chapter18;

public class HttpserverEx {

	public static void main(String[] args) {
		method(new LoginServer());//로그인 합니다.
		method(new FileDownloadServer());//파일 다운로드 합니다.
	}
	public static void method(Httpserver server) {
		server.Server();
	}

}
