package polymorphism;

import org.springframework.stereotype.Component;

@Component // ->id나 name 미지정시 lgTV라고 자동으로 이름이 지정됌
// <bean class="polymorphism.LgTV></bean> 으로 선언한것과 같은 효과
//@Component("tv")
//<bean id="tv" class="polymorphism.LgTV></bean> 으로 선언한것과 같은 효과
public class LgTV implements TV{
	public void powerOn() {
		System.out.println("LgTV---전원 켠다.");
	}
	
	public void powerOff() {
		System.out.println("LgTV---전원 끈다.");
	}
	
	public void volumeUp() {
		System.out.println("LgTV---소리올린다.");
	}
	
	public void volumeDown() {
		System.out.println("LgTV---소리내린다.");
	}
}
