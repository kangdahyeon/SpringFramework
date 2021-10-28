package polymorphism;

public class SamsungTV  implements TV{
	public SamsungTV() {
		System.out.println("====> SamsungTV객체 생성");
	}
	
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리---");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다.");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}
	
	public void volumeUp() {
		System.out.println("SamsungTV---소리올린다.");
	}
	
	public void volumeDown() {
		System.out.println("SamsungTV---소리내린다.");
	}
}
