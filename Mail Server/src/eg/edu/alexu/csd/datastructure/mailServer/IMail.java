package eg.edu.alexu.csd.datastructure.mailServer;

public interface IMail {
	
	public void setEmail(String msg) ;
	
	public void setAttachment(String Attach) ;
	
	public void setMainSubject(String main) ;
	
	public void setSender(String user) ;
	
	public void setReceivers(String user);
	
	public void setPriority(int p);
	
	public String  getEmail() ;
	
	public SinglyLinkedList getAttachment() ;
	
	public String getMainSubject() ;
	
	public String getSender() ;
	
	public LinkedListQueue getReceivers();
	
	public int getPriority() ;

}
