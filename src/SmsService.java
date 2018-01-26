
public class SmsService implements IMessage {
	

	public void sendMessage(String msg_from, String msg_to , String message) {
		
		System.out.println("Sending SMS to number " + msg_to);
	}

}
