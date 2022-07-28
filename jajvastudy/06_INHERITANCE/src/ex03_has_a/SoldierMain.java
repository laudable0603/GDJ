package ex03_has_a;

public class SoldierMain {

	public static void main(String[] args) {
		
		Gun gun = new Gun();
		
		gun.setModel("K2");
		gun.setBullet(9);
		
		
		
		
		
		
		Soldier soldier = new Soldier();
		soldier.setGun(gun);
		
		//soldier가 총을 쏜다.
		soldier.shoot();
		soldier.shoot();
		soldier.shoot();
		soldier.shoot();
		
		//soldier가 장전한다.
		soldier.reload(1);
		soldier.reload(1);
		soldier.reload(1);
		soldier.reload(1);
		soldier.reload(1);
		soldier.reload(1);
		soldier.reload(1);
		soldier.reload(1);
		soldier.reload(1);
		soldier.reload(1);
		soldier.reload(1);
		
		//sodier가 가지고 잇는 gun의 model/bullet
		System.out.println("총기 모델 : " + soldier.getGun().getModel());
		System.out.println("남은 총알 : " + soldier.getGun().getBullet());
		System.out.println( );
		
		

	}

}
