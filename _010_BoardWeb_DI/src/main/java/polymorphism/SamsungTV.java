package polymorphism;

public class SamsungTV  implements TV{
	SonySpeaker speaker;
	
	public SamsungTV() {
		System.out.println("====> SamsungTV객체 생성");
	}
	
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리---");
	}
	
	public void destroyMethod() {
		System.out.println("객체 삭제 전 처리할 로직---");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다.");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}
	
	public void volumeUp() {
		speaker = new SonySpeaker();
		speaker.volumeUp();
//		System.out.println("SamsungTV---소리올린다.");
	}
	
	public void volumeDown() {
		speaker = new SonySpeaker();
		speaker.volumeDown();
//		System.out.println("SamsungTV---소리내린다.");
	}
}
