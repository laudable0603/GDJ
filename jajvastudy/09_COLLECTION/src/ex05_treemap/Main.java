package ex05_treemap;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Main {

	public static void m1() {

		// 이진 트리(binary tree)
		// 1. 모든 노드는 2개의 자식을 가질 수 있다.
		// 2. 작은 값은 왼쪽, 큰값은 오른쪽에 저장한다.

		// TreeMap
		// 1. Key를 기준으로 왼쪽에 작은값, 오른쪽에 큰 값이 저장된다.
		// 2. Key를 기준으로 자동으로 정렬되면서 저장된다.
		// 3. 크기 비교 및 범위 연산에 적절하다.

		Map<Integer, String> map = new TreeMap<Integer, String>();

		map.put(65, "제시카");
		map.put(85, "에밀리");
		map.put(35, "제임스");
		map.put(95, "사만다");

		System.out.println(map); // Key를 기준으로 정렬되어 있음

		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}

	public static void m2() {

		// 기본 정령 : 오름차순 정렬
		// TreeMap타입은 TreeMap만 사용할 수 있는 메소드가 다수 있으므로
		// TreeMap타입으로 생성하는 것이 좋다.

		TreeMap<Integer, String> map = new TreeMap<Integer, String>();

		map.put(65, "제시카");
		map.put(85, "에밀리");
		map.put(35, "제임스");
		map.put(95, "사만다");

		// 정렬 변경 : decendingMap() 메소드 호출 //전환
		// 오름차순 정렬 ↔ 내림차순 정렬

		System.out.println("=======오름차순 > 내림차순 ========");
		NavigableMap<Integer, String> map2 = map.descendingMap();
		for (Map.Entry<Integer, String> entry : map2.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

		System.out.println("=======내림차순 > 오름차순 ========");

		// 다시 decendingMap() 메소드를 호출하면 오름차순 정렬이 된다.
		NavigableMap<Integer, String> map3 = map2.descendingMap();
		for (Integer key : map3.keySet()) {
			System.out.println(key + ":" + map3.get(key));
		}

	}

	public static void main(String[] args) {

		m2();

	}

}
