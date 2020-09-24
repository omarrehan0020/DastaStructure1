package eg.edu.alexu.csd.datastructure.mailServer;

public class Mail implements IMail {

	private String content ;
	private String sender ;
	private String mainSubject ;
	private int priority ;
	private SinglyLinkedList Attachment = new SinglyLinkedList() ;
	private LinkedListQueue receiversList = new LinkedListQueue() ;

	@Override
	public void setEmail(String msg) {
		this.content = msg ;
	}
	
	@Override
	public void setPriority(int p ) {
		this.priority=p ;
	}
	
	

	@Override
	public void setAttachment(String Attach) {
		this.Attachment.add(0,Attach);
	}

	@Override
	public void setMainSubject(String main) {
		this.mainSubject = main ;
	}
	
	@Override
	public void setSender(String user) {
		this.sender = user ;
	}
	
	@Override
	public void setReceivers(String user) {
		receiversList.enqueue(user);
	}
	
	
	@Override
	public String getEmail() {
		return this.content ;
	}

	@Override
	public SinglyLinkedList getAttachment() {
		return this.Attachment ;
	}
	
	@Override
	public String getMainSubject() {
		return this.mainSubject ;
	}
	
	@Override
	public String getSender() {
		return this.sender ;
	}
	
	@Override
	public LinkedListQueue getReceivers() {
		return this.receiversList ;
	}


	@Override
	public int getPriority() {
		return this.priority ;
	}
}
