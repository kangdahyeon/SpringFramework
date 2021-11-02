package polymorphism;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker {
	public AppleSpeaker() {
		System.out.println("====> 局敲胶乔目 按眉 积己");
	}
	public void volumeUp() {
		System.out.println("局敲胶乔目 -- 家府棵覆");
	}
	
	public void volumeDown() {
		System.out.println("局敲胶乔目 -- 家府郴覆");
	}
}
