package app;

import edu.princeton.cs.introcs.*;

//the link: http://tianqihoubao.com/lishi/beijing/month/201901.html

public class WeatherData {
	public static String getWordBefore(String html, int i) {
		String word = "";
		while (!Character.isSpaceChar(html.charAt(i))) {
			word = html.charAt(i--) + word;
		}
		return word;
	}

	public static void downloadWeatherData(String url) {
		System.err.println("Loading...");

		In page = new In(url); //new class "In" - reads everything you want it to read
		String html = page.readAll(); 
		
		Out o = new Out("downloaded_file.html"); //save it to a file, write it to disk
		o.print(html); //download and write it to the file

		
		System.err.println("Finished loading"); //print stuffs to the screen instead of to the (possible, through redirecton) csv

		//finding the data I want
		int lastIndex = 0;
		String pattern1 = "<a href='/lishi/beijing/"; //the piece of text in front of every data we want
		while (true) {
			int i1 = html.indexOf(pattern1, lastIndex); //if you don't have lastindex, it will always start from the beginning everytime
			if (i1 == -1) {
				break; //hitting the end of the data, we break
			}

			int i2 = html.indexOf(".html", i1); //finding ".html" after i1
			String date = html.substring(i1 + pattern1.length(), i2); //get the date out

			//get the highest temperature out
			int i3 = html.indexOf("℃", i2); //℃ is the 'weird' emoji for degree celsius
			if (i3 == -1) {
				break;
			}
			String high = getWordBefore(html, i3 - 1); //write the function to get the word before
			if (high.length() == 0) {
				break; 
			}
			System.out.println(date + "," + high);
			
			lastIndex = i3; //making sure the next time I search I start with where I ended last time
		}
	}

	public static void main(String[] args) {
		downloadWeatherData(args[0]);
	}
}

/**
 * when we use > to redirect the results to the file, it only redirect the stdout/systemout, not err
 * thats why we dont see "loading..." or "finished loading" in the csv
 */
