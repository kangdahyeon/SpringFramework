package polymorphism;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("====> 家聪胶乔目 按眉 积己");
	}
	public void volumeUp() {
		System.out.println("家聪胶乔目 -- 家府棵覆");
	}
	
	public void volumeDown() {
		System.out.println("家聪胶乔目 -- 家府郴覆");
	}
	
}
