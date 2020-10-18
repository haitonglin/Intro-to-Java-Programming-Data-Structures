package app;

import edu.princeton.cs.introcs.*;

//http://tianqihoubao.com/lishi/beijing/month/201901.html | java -cp bin:lib/stdlib-package.jar app.Statistics 1

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

		In page = new In(url);
		String html = page.readAll();
		
		Out o = new Out("downloaded_file.html");
		o.print(html);

		System.err.println("Finished loading");

		int lastIndex = 0;
		String city = url.substring(url.indexOf("lishi")+6, url.indexOf("month")-1);
		String pattern1 = "<a href='/lishi/"+city+"/";
		while (true) {
			int i1 = html.indexOf(pattern1, lastIndex);
			if (i1 == -1) {
				break;
			}

			int i2 = html.indexOf(".html", i1);
			String date = html.substring(i1 + pattern1.length(), i2);

			int i3 = html.indexOf("℃", i2);
			if (i3 == -1) {
				break;
			}

			String high = getWordBefore(html, i3 - 1);
			if (high.length() == 0) {
				break;
			}

			int i4 = html.indexOf("℃", i3+1);
			if (i4 == -1) {
				break;
			}

			String low = getWordBefore(html, i4 - 1);
			if (low.length() == 0) {
				break;
			}
			System.out.println(date + "," + high + "," + low);
			
			lastIndex = i4;
		}
	}

	public static void main(String[] args) {
		String a = args[0];
		CharSequence b = "html";
		if (a.contains(b)) downloadWeatherData(a);
		else {
			for (int i = 1; i < 10; i++){
				String c = a + "0" + i + ".html";
				downloadWeatherData(c);}
			for (int j = 10; j < 13; j++){
				String d = a + j + ".html";
				downloadWeatherData(d);}
		    }
	}
}