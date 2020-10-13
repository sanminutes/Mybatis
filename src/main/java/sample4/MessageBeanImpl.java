package sample4;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String greeting;
	private Outputter outputter;

	public MessageBeanImpl(String name) { // 생성자
		this.name = name;

	}

	public void setName(String name) { // 세터
		this.name = name;
	}

	public void setGreeting(String greeting) { // 세터
		this.greeting = greeting;
	}

	public void setOutputter(Outputter outputter) { // 세터
		this.outputter = outputter;
	}

	@Override
	public void sayHello() {
		String msg = greeting + name + "~";
		try {
			outputter.output(msg);

		} catch (Exception e) { // 출력
			e.printStackTrace();
		}

	}

}
