package src;

import java.util.Random;


/*
 * Usage:
 * 	
 *	//create default
 * 	Vector2D data = new Vector2D();
 *
 * 	//size of Vector2D
 * 	data.size();
 *
 *	//access mutable elements form vectors x and y.
 *	// k is an integer between 0 and data.size()
 * 	data.x[k];
 * 	data.y[k];
 *
 *	//mutate a planar data point
 *	data.x[1] = -1.2;
 *	data.y[1] = 3000.5;
 *
 *	//insert pseudorandom values in the Vector2D
 *	data.randomize();
 *
 */

public class Vector2D {
	public double[] x;
	public double[] y;
	private int m_size;
	
	public Vector2D(){
		this.x = new double[100];	
		this.y = new double[100];	
		this.m_size = 100;
	}
	public Vector2D(int size){
		this.x = new double[size];	
		this.y = new double[size];	
		this.m_size = size;
	}

	//Inserts pseudorandom numbers from -1 000 000 to 1 000 000 in x and y.
	public void randomize(){
		this.x = new double[100];
		this.y = new double[100];
		this.m_size = 100;

		Random rand = new Random();
		double min = -1000000.0;
		double max = +1000000.0;

		for(int i = 0; i <m_size; i++){
			this.x[i] = min + rand.nextDouble() * (max - min);	
			this.y[i] = min + rand.nextDouble() * (max - min);	
		}
	}

	public int size(){
		return m_size;
	}
}
