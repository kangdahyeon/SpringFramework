package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component // ->id�� name �������� lgTV��� �ڵ����� �̸��� ������
// <bean class="polymorphism.LgTV></bean> ���� �����ѰͰ� ���� ȿ��
//<bean id="tv" class="polymorphism.LgTV></bean> ���� �����ѰͰ� ���� ȿ��
@Component("tv")
public class LgTV implements TV {
	// @Autowired ������̼� ��� �� ������, setter�޼ҵ带 �̿��� ������ ������ �̷���������
	// @Qualifier :  ������ Ÿ���� ��ü�� �� ���̻� �����Ǿ� ���� �� ��Ȯ�ϰ� �����ؼ� ������ ������ �� ���
	
//	@Qualifier("apple")
	// @Resource " @Autowired + @Qualifier Ÿ�԰� �̸����� �ڵ����� �����Ͽ� ������ ����
//	@Resource(name="apple")
	@Autowired
	private Speaker speaker;
	
	public void powerOn() {
		System.out.println("LgTV---���� �Ҵ�.");
	}
	
	public void powerOff() {
		System.out.println("LgTV---���� ����.");
	}
	
	public void volumeUp() {
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		speaker.volumeDown();
	}
}
