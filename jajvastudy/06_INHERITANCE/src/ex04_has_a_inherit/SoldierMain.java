package ex04_has_a_inherit;

public class SoldierMain {

	public static void main(String[] args) {
		
		
		
		Soldier soldier = new Soldier();
		soldier.reload(1);
		soldier.shoot();
		
		
		System.out.println(soldier.getBullet());
		
	}

}
