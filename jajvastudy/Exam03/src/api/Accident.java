package api;

public class Accident {
	
	private String occrrncDt; // 발생월일시
	private String occrrncDayCd;  // 발생요일코드 (4)
	private int dthDnvCnt;  // 사망자수 (0)
	private int injpsnCnt;  // 부상자수 (1)
	
	
	
	
	public Accident(Builder builder) {
		
		this.occrrncDt = builder.occrrncDt;
		this.occrrncDayCd = builder.occrrncDayCd;
		this.dthDnvCnt = builder.dthDnvCnt;
		this.injpsnCnt = builder.injpsnCnt;
	}
	
	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		
		private String occrrncDt; 
		private String occrrncDayCd;  
		private int dthDnvCnt;  
		private int injpsnCnt;  
		
		public Builder occrrncDt(String occrrncDt) {
			this.occrrncDt = occrrncDt;
			return this;
		}
		public Builder occrrncDayCd(String occrrncDayCd) {
			this.occrrncDayCd = occrrncDayCd;
			return this;
		}
		public Builder dthDnvCnt(int dthDnvCnt) {
			this.dthDnvCnt = dthDnvCnt;
			return this;
		}
		public Builder injpsnCnt(int injpsnCnt) {
			this.injpsnCnt = injpsnCnt;
			return this;
		}
		
		public Accident build() {
			return new Accident(this);
		}
		
		
		
	}

	@Override
	public String toString() {
		return "Accident [발생일자 =" + occrrncDt + ", 요일=" + occrrncDayCd + ", 사망자수=" + dthDnvCnt
				+ ", 부상자수=" + injpsnCnt + "]";
	}
	
	
}
