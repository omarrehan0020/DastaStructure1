package eg.edu.alexu.csd.datastructure.mailServer;

public class Contact implements IContact {
	
	private String username ;
	private String password ;
	private String RepeatPassword ;

	@Override
	public void SetUsername(String user) {
		username = user ;
	}

	@Override
	public void SetPassword(String pass) {
		password = pass ;
	}
	
	public void SetRepeatPassword(String pass) {
		RepeatPassword = pass ;
	}
	

	@Override
	public String GetUsername() {
		return username ;
	}

	@Override
	public String GetPassword() {
		return password ;

	}
	public String GetRepeatPassword() {
		return RepeatPassword ;

	}

}
