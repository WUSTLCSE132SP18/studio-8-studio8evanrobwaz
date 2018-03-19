package studio8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// TODO: Develop an algorithm to count steps in accelerometer data
//    Major steeps:
//       1. Create a class and main method.
//       2. Using a Scanner and File object, read data from your .csv file.
//       3. Develop and test algorithms to count the "peaks" in the data.

public class CountSteps {
	public static void main (String[] args) throws FileNotFoundException {
		Scanner S = new Scanner(new File("/CSE132-studio8/data/GraphThis.csv"));

		List<Double> x = new ArrayList<Double>();
		List<Double> y = new ArrayList<Double>();
		List<Double> z = new ArrayList<Double>();
		List<Double> xp = new ArrayList<Double>();
		List<Double> yp = new ArrayList<Double>();
		List<Double> zp =new ArrayList<Double>();
		int count=0;
		String tempstr[]=new String[3];
		String temp = "";

		while(S.hasNext()) {
			temp=S.nextLine();
			tempstr = temp.split(",");
			x.add(Double.parseDouble(tempstr[0]));
			y.add(Double.parseDouble(tempstr[1]));
			z.add(Double.parseDouble(tempstr[2]));
			count+=1;
		}
		
		for(int i = 0;i<count;++i) {
			if((i != 0) && (i+1 != count)){
				if((x.get(i) > x.get(i-1)) && ((x.get(i) > x.get(i+1)))){
					xp.add(x.get(i));
				}
				if((y.get(i) > y.get(i-1)) && ((y.get(i) > y.get(i+1)))){
					yp.add(y.get(i));
				}
				if((z.get(i) > z.get(i-1)) && ((z.get(i) > z.get(i+1)))){
					zp.add(z.get(i));
				}
			}
		}
		S.close();
	}
}

