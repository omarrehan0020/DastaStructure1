package eg.edu.alexu.csd.datastructure.mailServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Date;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;


public class App implements IApp {
	
	private SinglyLinkedList index = new SinglyLinkedList() ;
	private SinglyLinkedList mailsToMove = new SinglyLinkedList() ;
	
	public boolean signin(String email, String password) throws IOException {
		
		//in case there is no email or no password
		if (password =="" || email == "")
			{
			  JOptionPane.showMessageDialog(null, "please , enter an email and password !!",  "Hey!", JOptionPane.ERROR_MESSAGE);
              return false ;
			}
		email = email.toLowerCase() ;
		//check if email is exist or not
		String userPath = "users/" + email ;
		Path mypath = Paths.get(userPath);
		if (! Files.exists(mypath))
		{
			JOptionPane.showMessageDialog(null, "this email is wrong",  "Hey!", JOptionPane.ERROR_MESSAGE);
			return false ;
		}
		else
		{
			String passFile = userPath + "/password.txt" ;
			String pass ;
			BufferedReader brTest = new BufferedReader(new FileReader(passFile));
		    pass = brTest .readLine();
		    if ( pass.equals(password))
		    {
		    	JOptionPane.showMessageDialog(null, "You sign in successfully");
		    	return true ;
		    }
		    else
		    {
				  JOptionPane.showMessageDialog(null, "the password is wrong",  "Hey!", JOptionPane.ERROR_MESSAGE);
				  return false ;
		    }
		}
		
		
	}
	
	public boolean signup(IContact contact) throws IOException {
		
		if (contact.GetPassword().equals("") || contact.GetUsername().equals(""))
		{
			  JOptionPane.showMessageDialog(null, "please , enter correct email and password !!",  "Hey!", JOptionPane.ERROR_MESSAGE);
              return false ;
		}
		if (!contact.GetPassword().equals(contact.GetRepeatPassword()))
		{
			 JOptionPane.showMessageDialog(null, "Two passwords aren't matched !!",  "Hey!", JOptionPane.ERROR_MESSAGE);
             return false ;
		}
		
		contact.SetUsername(contact.GetUsername().toLowerCase());
		
		//create folder that catch all users created if not exist
		Path mypath = Paths.get("users");
		 if (!Files.exists(mypath))
			 Files.createDirectories(mypath);
		 
		 
		 
		 //create new user and save password in file inside it
		 String fileName = "users/" + contact.GetUsername() ;
		 		 
		  mypath = Paths.get(fileName);
		  if (!Files.exists(mypath))
		  {
			  Files.createDirectories(mypath);
			  JOptionPane.showMessageDialog(null, "New email has been crerated successfully");
		  }
		  else 
		  {
			  JOptionPane.showMessageDialog(null, "this email is already exist!",  "Hey!", JOptionPane.ERROR_MESSAGE);
			  return false ;
		  }
		  
		  String password = fileName + "/password.txt" ;
		  mypath = Paths.get(password);
		  File passFile = new File(password) ;
		  if (! passFile.exists())
			  passFile.createNewFile() ;
		  try
	        {
	        FileWriter fileWr = new FileWriter(passFile.getAbsoluteFile(), true);
	        BufferedWriter bufferedWr = new BufferedWriter(fileWr);
	       
	        bufferedWr.write(contact.GetPassword());
	        bufferedWr.newLine();
	        bufferedWr.close();
	        fileWr.close();
	        }
	        catch(IOException ex) {
	              ex.printStackTrace();
	            }
		  
		  
		  
		  //save new user information in file of all users
		  File textFile = new File("users/Emails.txt");
		  if (! textFile.exists())
			  textFile.createNewFile() ;
		  try
	        {
	        FileWriter fileWriter = new FileWriter(textFile.getAbsoluteFile(), true);
	        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	       
	        bufferedWriter.write(contact.GetUsername());
	        bufferedWriter.newLine();
	        bufferedWriter.close();
	        fileWriter.close();
	        }
	        catch(IOException ex) {
	              ex.printStackTrace();
	            }
		return true ;
		 
	}
	
	private boolean SendingAndReceivingEmail(String from ,String to,Mail folder) throws IOException
	{
		String sender = "users/" + from ;
		String reciever = "users/" + to ;
		Path path1 = Paths.get(sender);
		Path path2 = Paths.get(reciever);
		
		if (! Files.exists(path1))
		{
			  JOptionPane.showMessageDialog(null, "the usermail of sender is wrong",  "Hey!", JOptionPane.ERROR_MESSAGE);
			  return false ;
		}
		if (! Files.exists(path2))
		{
			  JOptionPane.showMessageDialog(null, "the usermail of receiver is wrong",  "Hey!", JOptionPane.ERROR_MESSAGE);
			  return false ;
		}
		
		//to save it in inbox box
		int i = 1 ;
		String in  ="users/" + to +"/inbox" ;
		Path inboxpath = Paths.get(in);
		if (! Files.exists(inboxpath))
		{
			 Files.createDirectories(inboxpath);
		}
		
		
		
		//create mail folder inside inbox folder and store content and attachment
		
		//create mail folder inside inbox folder
		String mail_content = in +"/"+folder.getMainSubject() ;
		Path mail = Paths.get(mail_content) ;
		while (Files.exists(mail))
		{
			mail_content = in +"/"+ folder.getMainSubject() + "(" + i++ + ")" ;
			mail = Paths.get(mail_content) ;
		}
		
		Files.createDirectories(mail);
		
		//store mail information in index file inside inbox folder
			String index = in + "/index.txt" ;
			File indexFile = new File(index) ;
			if (! indexFile.exists())
			{
				indexFile.createNewFile() ;
			}
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now(); 
			try
	        {
	        FileWriter file = new FileWriter(indexFile.getAbsoluteFile(), true);
		    BufferedWriter buffered = new BufferedWriter(file);
		    if (i > 1)
		    {
		        buffered.write(folder.getMainSubject()+ "(" + --i + ")" + " ");
		    }else 
		    {
		        buffered.write(folder.getMainSubject()+ " ");
		    }
		    buffered.write(from+" ");
		    buffered.write(to+" ");
		    buffered.write(dtf.format(now) +" ");
		    buffered.write(new Integer(folder.getPriority()).toString());
		    
		     buffered.newLine();
		     buffered.close();
		     file.close();
		     }
		     catch(IOException ex) {
		           ex.printStackTrace();
		      }
		
			
			

		//store mail content 
		String content = mail_content + "/content.txt" ;
		File mail_con = new File(content) ;
		mail_con.createNewFile() ;
		try
        {
        FileWriter file = new FileWriter(mail_con.getAbsoluteFile(), true);
        BufferedWriter buffered = new BufferedWriter(file);
       
        buffered.write(folder.getMainSubject()+" ");
        buffered.write(from+" ");
        buffered.write(to+" ");
        buffered.write(dtf.format(now));
        buffered.newLine();
        buffered.write(folder.getEmail());
        
        buffered.close();
        file.close();
        }
        catch(IOException ex) {
              ex.printStackTrace();
            }
		
		
		//store mail attachment
		String AttachmentFolder = mail_content + "/Attachments";
		Path AttachmentPath = Paths.get(AttachmentFolder);
		String dest ="" ;
		String src ="" ;
		SinglyLinkedList AttachmentsList = folder.getAttachment() ;
		for (int j=0 ;j<AttachmentsList.size() ;j++)
		{
			if (! Files.exists(AttachmentPath))
			{
				 Files.createDirectories(AttachmentPath);
			}
		    src = (String) AttachmentsList.get(j) ;
			File sourceFile = new File(src);

		    dest = AttachmentFolder +"/"+ sourceFile.getName() ;
			File destFile = new File(dest);
		   copy(sourceFile ,destFile) ;
		}
		
		
		//to save it in sent box
				 i = 1 ;
				String s  ="users/" + from +"/sent" ;
				Path sentpath = Paths.get(s);
				if (! Files.exists(sentpath))
				{
					 Files.createDirectories(sentpath);
				}
				
				
				
				//create mail folder inside sent folder and store content&attachment
				
				//create mail folder inside sent folder
			    mail_content = s +"/"+folder.getMainSubject() ;
			    mail = Paths.get(mail_content) ;
				Files.createDirectories(mail);
				
				//store mail information in sent file inside sent folder
					String sent = s + "/sent.txt" ;
					File sentFile = new File(sent) ;
					if (! sentFile.exists())
					{
						sentFile.createNewFile() ;
					}
					 dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
					 now = LocalDateTime.now(); 
					try
			        {
			        FileWriter file = new FileWriter(sentFile.getAbsoluteFile(), true);
				    BufferedWriter buffered = new BufferedWriter(file);
				    if (i > 1)
				    {
				        buffered.write(folder.getMainSubject()+ "(" + --i + ")" + " ");
				    }else 
				    {
				        buffered.write(folder.getMainSubject()+ " ");
				    }
				    buffered.write(from+" ");
				    buffered.write(to+" ");
				    buffered.write(dtf.format(now));
				        
				        
				     buffered.newLine();
				     buffered.close();
				     file.close();
				     }
				     catch(IOException ex) {
				           ex.printStackTrace();
				      }

				//store mail content 
				 content = mail_content + "/content.txt" ;
				 mail_con = new File(content) ;
				mail_con.createNewFile() ;
				try
		        {
		        FileWriter file = new FileWriter(mail_con.getAbsoluteFile(), true);
		        BufferedWriter buffered = new BufferedWriter(file);
		       
		        buffered.write(folder.getMainSubject()+" ");
		        buffered.write(from+" ");
		        buffered.write(to+" ");
		        buffered.write(dtf.format(now));
		        buffered.newLine();
		        buffered.write(folder.getEmail());
		        buffered.newLine();
		        
		        
		        buffered.close();
		        file.close();
		        }
		        catch(IOException ex) {
		              ex.printStackTrace();
		            }
				
				
				//store mail attachment
				 AttachmentFolder = mail_content + "/Attachments";
				 AttachmentPath = Paths.get(AttachmentFolder);
				 dest ="" ;
				 src ="" ;
				 AttachmentsList = folder.getAttachment() ;
				for (int j=0 ;j<AttachmentsList.size() ;j++)
				{
					if (! Files.exists(AttachmentPath))
					{
						 Files.createDirectories(AttachmentPath);
					}
				    src = (String) AttachmentsList.get(j) ;
					File sourceFile = new File(src);

				    dest = AttachmentFolder +"/"+ sourceFile.getName() ;
					File destFile = new File(dest);
				   copy(sourceFile ,destFile) ;
				}
				
				return true ;
		
		
	}
	
	private static void copy(File src, File dest) throws IOException{
		InputStream is = null;
		OutputStream os = null;
		try { 
			is = new FileInputStream(src);
			os = new FileOutputStream(dest); 
			// buffer size 1K 
			byte[] buf = new byte[1024];
			int bytesRead;
			while ((bytesRead = is.read(buf)) > 0)
			    {
				os.write(buf, 0, bytesRead);
				} 
			is.close();
			os.close();
		}catch(IOException ioe){
    		ioe.printStackTrace();
    	 }
		
		}

	
	private static void move(File sourceFile, File destFile)
	{
		try {
			Files.move(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public boolean compose(IMail email) throws IOException {

		LinkedListQueue r = email.getReceivers() ;
		boolean x=false ;
		if (r.isEmpty())
			return false ;
		while (r.size() > 0)
		{
			String rec = (String) r.dequeue() ;
			  x = this.SendingAndReceivingEmail(email.getSender(), rec , (Mail) email);
			  if (x == false) break ;
			this.prioritytextFile(rec);
		}
		return x ;
	}

	private void prioritytextFile(String receiver) throws IOException {
		//create priority Queue 
		PriorityQueue priority = new PriorityQueue() ;
		
		//create priority file if not exist
		String prioritytxt = "users/" + receiver +"/inbox/priority.txt" ;
		File  priorityFile = new File(prioritytxt) ;
		if (! priorityFile.exists() )
		{
			priorityFile.createNewFile() ;
		}
		
		//read from index file line by line and story it in priority queue
		String indextext = "users/" + receiver +"/inbox/index.txt" ;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(indextext));
			String line = reader.readLine();
			while (line != null) {
				String[] splited = line.split(" ");
				int x= Integer.parseInt(splited[splited.length-1].trim()) ;
				priority.insert(line, x);
				line = reader.readLine();	
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//clear priority file
		FileWriter fwOb = new FileWriter(prioritytxt, false); 
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
        
        //store each item in priority queue to priority file 
        while (! priority.isEmpty())
        {
        	try
	        {
        		String str =(String) priority.removeMin() ;
		        FileWriter file = new FileWriter(priorityFile.getAbsoluteFile(), true);
			    BufferedWriter buffered = new BufferedWriter(file);
			    buffered.write(str);
			    buffered.newLine();
			    buffered.close();
			    file.close();
		     }
		     catch(IOException ex) {
		           ex.printStackTrace();
		      }
        }
		
	}
	
	private void DeleteIntoTrachBox(String user ,String todelete) throws IOException {
		
		//create trash folder if not exist
		String trash = "users/" + user + "/trash" ;
		Path path1 = Paths.get(trash) ;
		if (! Files.exists(path1))
		{
			Files.createDirectories(path1);
		}
		//move email todelete into trash box
		String src = "users/" + user + "/inbox/" + todelete  ;
		File sourceFile = new File(src);
		
		String dest = "users/" + user + "/trash/" + todelete ;
		File destFile = new File(dest) ;
		
		move(sourceFile ,destFile) ;
		
		
		//remove Line from index file
		SinglyLinkedList o = this.indexFileToLinkedList("users/" + user + "/inbox/index.txt") ;
	
		//clear index file
				FileWriter fwOb = new FileWriter("users/" + user + "/inbox/index.txt", false); 
		        PrintWriter pwOb = new PrintWriter(fwOb, false);
		        pwOb.flush();
		        pwOb.close();
		        fwOb.close();
		 int i=0 ;
		 File in = new File("users/" + user + "/inbox/index.txt") ;
		while (i < o.size()) {
			String line =(String) o.get(i++);
			String[] splited = line.split(" ");
			if (! todelete.equals(splited[0]))
			{
				try
		        {
		        FileWriter file = new FileWriter(in.getAbsoluteFile(), true);
			    BufferedWriter buffered = new BufferedWriter(file);
			    buffered.write(line);
			     buffered.newLine();
			     buffered.close();
			     file.close();
			     }
			     catch(IOException ex) {
			           ex.printStackTrace();
			      }
			}
		}
		//remove Line from priority file 
		this.prioritytextFile(user);
		
		//auto delete after 30 days
				dest = "users/" + user + "/trash/" + todelete ;
				 destFile = new File(dest) ;
                 this.deleteFilesOlderThanNdays(dest);		
	
	}
	
	private static boolean deleteDirectory(File directoryToBeDeleted) {
	    File[] allContents = directoryToBeDeleted.listFiles();
	    if (allContents != null) {
	        for (File file : allContents) {
	            deleteDirectory(file);
	        }
	    }
	    return directoryToBeDeleted.delete();
	}
	
	private void deleteFilesOlderThanNdays(String dirWay)
    {
		  File directory = new File(dirWay);
        if(directory.exists())
        {   
  		  ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
		
		  	Runnable task = new Runnable() {
		  	public void run() {
		  		deleteDirectory(directory) ;
		  	}
		  	};
		
		  	scheduler.schedule(task, 30, TimeUnit.DAYS);
		  	scheduler.shutdown();
        }   
		          
		       
    }
	
    private SinglyLinkedList indexFileToLinkedList (String s) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(s));
			String line = reader.readLine();
			while (line != null) {
				this.index.add(line);
				line = reader.readLine();	
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.index ;
	}

    private  void setMails(String s)
    {
    	mailsToMove.add(s);
    }

    public void moveEmails(SinglyLinkedList mails, String des) {
         while (! mailsToMove.isEmpty())
         {
        	 String ss = (String)mailsToMove.get(0);
        	 mailsToMove.remove(0);
        	 
        	
     		 File sourceFile = new File(ss);
     		
     		String dest = des + "/" +sourceFile.getName();
     		File destFile = new File(dest) ;
        	 move( sourceFile,  destFile);
        	 
         }
    }


    public void deleteEmails(SinglyLinkedList mails,String user) throws IOException {
    	while(! mailsToMove.isEmpty())
    	{
    		 String ss = (String)mailsToMove.get(0);
        	 mailsToMove.remove(0);
        	 File sourceFile = new File(ss);	
        	 this.DeleteIntoTrachBox(user, sourceFile.getName());
        	 
        	 
        	
    	}
    }

	
	

	
	 public static void main(String[] args) throws IOException, ParseException {
		 Contact contact = new Contact() ;
		 contact.SetPassword("123456");
		 contact.SetUsername("ali");
		 App o = new App() ;
		 Mail f = new Mail() ;
		 f.setReceivers("omarrehan14");
		 f.setReceivers("omarrehan35");
		 f.setSender("omarrehan0020");
		 f.setEmail("ghfhgdfghjd djhgjkhd djkhdjkhd ");
		 f.setMainSubject("zzam");
		 f.setPriority(90);
		 f.setAttachment("C:\\Users\\future\\Desktop\\Capture2.png");
		 f.setAttachment("C:\\Users\\future\\Desktop\\Capture1.png");
		 /*
		 o.setMails("users/omar/inbox/ihuh");
		 o.setMails("users/ali/sent/kjsljks");
		 o.setMails("users/ziad/sent/xoiuo");
		 o.moveEmails(o.mailsToMove,"users/rehan/sent");
		 
		 */
		 
	 //  o.signup(contact);
		// o.compose(f);
		
		
	 }
	 
	 
}
