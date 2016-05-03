
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		String fileName = args[0];
		File file = new File("src", fileName);

		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		StringBuffer buff = new StringBuffer();
		String line = null;

		boolean isMultipleLine = false;
		int index = 1;

		while ((line = in.readLine()) != null) {
			String originLine = line;
			// System.out.println(line);
			String[] array = line.split("=");
			if (isMultipleLine) {
				buff.append("\n");
			} else {
				buff.append(array[0])
					.append("\n");
			}
			isMultipleLine = line.trim().endsWith("\\");
			//if (isMultipleLine) {
			//	System.out.println(index + " " + line);
			//}
			//if (index == 759) {
			//	System.out.println(originLine);
			//}
			index++;
		}
		in.close();

		File outputFile = new File("dest", fileName);
		FileOutputStream fos = new FileOutputStream(outputFile);
		fos.write(buff.toString().getBytes());
		fos.flush();
		fos.close();
	}
}
