package polymorphism;

public class SamsungTV  implements TV{
	
	private SonySpeaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("====> SamsungTV객체(1) 생성");
	}
	
	public SamsungTV(SonySpeaker speaker) {
		System.out.println("====> SamsungTV 객체(2)생성");
		this.speaker = speaker;
	}
	public SamsungTV(SonySpeaker speaker, int price) {
		System.out.println("객체(3)생성");
		this.speaker = speaker;
		this.price = price;
	}

	public void initMethod() {
		System.out.println("객체 초기화 작업 처리---");
	}
	
	public void destroyMethod() {
		System.out.println("객체 삭제 전 처리할 로직---");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다. 가격 : " + price);
	}
	
	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}
	
	public void volumeUp() {
//		speaker = new SonySpeaker();
		speaker.volumeUp();
//		System.out.println("SamsungTV---소리올린다.");
	}
	
	public void volumeDown() {
//		speaker = new SonySpeaker();
		speaker.volumeDown();
//		System.out.println("SamsungTV---소리내린다.");
	}
}
