package polymorphism;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("====> �ҴϽ���Ŀ ��ü ����");
	}
	public void volumeUp() {
		System.out.println("�ҴϽ���Ŀ -- �Ҹ��ø�");
	}
	
	public void volumeDown() {
		System.out.println("�ҴϽ���Ŀ -- �Ҹ�����");
	}
	
}
