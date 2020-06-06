import javax.swing.JOptionPane;

public class calculate implements ICalculator {

	private float h ;
	@Override
	public int add(int x, int y) {
		return x + y ;
	}

	@Override
	public float divide(int x, int y) throws RuntimeException {
		try {
			 h = (float) x / y ;
			
		}catch(Exception E)
		{
			JOptionPane.showMessageDialog(null,"you can not divide by zero ");
		}
		
		return h ;
	}

	
}
