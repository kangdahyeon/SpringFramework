package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component // ->id나 name 미지정시 lgTV라고 자동으로 이름이 지정됌
// <bean class="polymorphism.LgTV></bean> 으로 선언한것과 같은 효과
@Component("tv")
//<bean id="tv" class="polymorphism.LgTV></bean> 으로 선언한것과 같은 효과
public class LgTV implements TV {
	// @Autowired 어노테이션 사용 시 생성자, setter메소드를 이용한 의존성 주입이 이뤄지지않음
	@Autowired
	private Speaker speaker;
	
	public void powerOn() {
		System.out.println("LgTV---전원 켠다.");
	}
	
	public void powerOff() {
		System.out.println("LgTV---전원 끈다.");
	}
	
	public void volumeUp() {
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		speaker.volumeDown();
	}
}
