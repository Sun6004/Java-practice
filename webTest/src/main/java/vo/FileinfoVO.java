package vo;

public class FileinfoVO {
	private int FILE_NO;
	private String FILE_WRITER;
	private String ORIGIN_FILE_NAME;
	private String SAVE_FILE_NAME;
	private long FILE_SIZE;
	private String FILE_DATE;
	public int getFILE_NO() {
		return FILE_NO;
	}
	public void setFILE_NO(int fILE_NO) {
		FILE_NO = fILE_NO;
	}
	public String getFILE_WRITER() {
		return FILE_WRITER;
	}
	public void setFILE_WRITER(String fILE_WRITER) {
		FILE_WRITER = fILE_WRITER;
	}
	public String getORIGIN_FILE_NAME() {
		return ORIGIN_FILE_NAME;
	}
	public void setORIGIN_FILE_NAME(String oRIGIN_FILE_NAME) {
		ORIGIN_FILE_NAME = oRIGIN_FILE_NAME;
	}
	public String getSAVE_FILE_NAME() {
		return SAVE_FILE_NAME;
	}
	public void setSAVE_FILE_NAME(String sAVE_FILE_NAME) {
		SAVE_FILE_NAME = sAVE_FILE_NAME;
	}
	public long getFILE_SIZE() {
		return FILE_SIZE;
	}
	public void setFILE_SIZE(long fILE_SIZE) {
		FILE_SIZE = fILE_SIZE;
	}
	public String getFILE_DATE() {
		return FILE_DATE;
	}
	public void setFILE_DATE(String fILE_DATE) {
		FILE_DATE = fILE_DATE;
	}
	@Override
	public String toString() {
		return "FileinfoVO [FILE_NO=" + FILE_NO + ", FILE_WRITER=" + FILE_WRITER + ", ORIGIN_FILE_NAME="
				+ ORIGIN_FILE_NAME + ", SAVE_FILE_NAME=" + SAVE_FILE_NAME + ", FILE_SIZE=" + FILE_SIZE + ", FILE_DATE="
				+ FILE_DATE + "]";
	}
	
	
}
