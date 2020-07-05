package eg.edu.alexu.csd.datastructure.iceHockey;

import java.awt.List;
import java.awt.Paint;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;


public class findPlayer implements IPlayersFinder {
	
	
	private String[] photoCopy ;
	private boolean[][] maker ;
	private int  count=0 ;
	private int teamCopy ;
	private int n ,m ;
	
	Point max = new Point(0,0) ;
	Point min = new Point(0,0) ;
	

	
	public int setLocation(int row , int col)
	{
		for (int i=-1 ;i<=1 ;i++)
		{
			for (int j=-1 ;j<=1 ;j++)
			{
				if ((i+row)>=0 && (i+row) < n && (col + j)>=0 && (col + j) < m && (i+j) != 0 && i!=j)
				{
					if (photoCopy[row+i].charAt(col+j) == (char)('0'+teamCopy) && ! maker[row+i][col+j] )
					{
						maker[row+i][col+j] = true ;
						count++ ;
						if (col+j < min.x)
							min.x = col+j ;
						if (col+j>max.x)
							max.x = col+j ;
						if (row+i <min.y)
							min.y=row+i ;
						if(row+i> max.y)
							max.y = row+i ;
						this.setLocation(row+i, col+j) ;
						
					}
				}
			}
		}
		
		return count ;
	}
	
	private void sort (Point[] points)
	{
		for(int i=0 ;i<points.length-1 ;i++)
		{
			for (int j=i+1 ;j<points.length ;j++)
			{
				if (points[i].x > points[j].x)
				{
					Point temp = new Point() ;
					temp = points[i] ;
					points[i] = points[j] ;
					points[j] = temp ;
					
				}else if (points[i].x == points[j].x)
					if (points[i].y > points[j].y)
					{
						Point temp = new Point() ;
						temp = points[i] ;
						points[i] = points[j] ;
						points[j] = temp ;
					}
			}
		}
	}

	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		//check if image is empty
		if (photo.length == 0 || photo == null)
			return null ;
		
		
		
		n = photo.length ;
		m = photo[0].length() ;
		boolean[][] mask = new boolean[n][m] ;
		for ( int k=0 ;k<n ;k++)
		{
			for (int l=0 ;l<m ;l++ )
			{
				mask[k][l] = false ;
			}
		}
		
		photoCopy = photo ;
		teamCopy = team ;
		maker = mask ;
		
		
		ArrayList<Point> Location = new ArrayList<Point>() ;
		
		for(int i=0 ;i<n ;i++)
		{
			for(int j=0 ;j<m ;j++)
			{
				if (photo[i].charAt(j) == (char) ('0' +team ) && !mask[i][j])
				{
					mask[i][j] = true ;
					count++ ;
					min.x = j ;
					min.y = i ;
					max.x = j ;
					max.y = i ;
					count = this.setLocation(i, j);
					
					if (count >=  (float)threshold / 4)
					{
						Point temp = new Point(min.x + max.x +1 ,min.y + max.y +1) ;
						Location.add(temp) ;
					}
					
					count = 0 ;
					
				}
				
				
			}
		}
		
		
		Point[] points = new Point[Location.size()] ;
		for (int i=0 ;i<Location.size() ;i++)
		{
			points[i] = Location.get(i) ;
		}
		
		
		this.sort(points);
		
		return   points;
		
		
		
	}
	
	
	
}
