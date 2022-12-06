package ex02_lambda.sec04;

public class Main {

	public static void main(String[] args) {
		
		Soil soil = new Soil();
		soil.sellOil(() -> {
				int oil = 30;
				soil.setTotalOil(soil.getTotalOil() - oil);
				soil.setEarning(soil.getEarning() + oil * soil.getPayPerLiter());
				System.out.println("감사합니다.BMW, "+ oil * soil.getPayPerLiter()+"원 지불");
		});
		soil.sellOil(() -> {
				int oil = 80;
				soil.setTotalOil(soil.getTotalOil() - oil);
				soil.setEarning(soil.getEarning() + oil * soil.getPayPerLiter());
				System.out.println("감사합니다. 소나타, " + oil * soil.getPayPerLiter() + "원 지불");
		});
		
		System.out.println(soil.getTotalOil());
		System.out.println(soil.getEarning());

	}

}
