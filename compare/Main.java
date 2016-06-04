
import java.io.*;
import java.util.*;

public class Main implements Comparator<String> {

	public int compare(String o1, String o2) {
		o1 = o1.toLowerCase();
		o2 = o2.toLowerCase();
		// System.out.println(o1 + " " + o2);
		int len = o1.length() < o2.length() ? o1.length() : o2.length();
		// return o1.compareTo(o2);
		for (int i = 0; i < len; i++) {
			char c1 = o1.charAt(i);
			char c2 = o2.charAt(i);
			if (c1 == c2) {
				continue;
			}
			if (c1 == '_') {
				return 1;
			}
			if (c2 == '_') {
				return -1;
			}
			return c1 - c2;
		}
		if (o1.length() == o2.length()) {
			return 0;
		}

		if (o1.length() < o2. length()) {
			if (o2.charAt(len) == '-' || o2.charAt(len) == '.') {
				return 1;
			}
			return -1;
		} else {
			if (o1.charAt(len) == '-' || o1.charAt(len) == '.') {
				return -1;
			}
			return 1;
		}
	}

	public boolean equals(Object o) {
		return this == o;
	}

	public static void main(String[] args) throws Exception {
		String fileName = args[0];
		copy(fileName);
		// sort(fileName);
	}

	public static void copy(String fileName) throws Exception {
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

	public static void sort(String fileName) throws Exception {
		File file = new File("src", fileName);

		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		// StringBuffer buff = new StringBuffer();
		String line = null;

		boolean isMultipleLine = false;
		int index = 1;

		Map<String, String> map = new TreeMap<String, String>(new Main());

		String key = "";
		String value = "";

		while ((line = in.readLine()) != null) {
			if (line.startsWith("#")) {
				// comment
				continue;
			}
			if ("".equals(line.trim())) {
				// blank
				continue;
			}

			String originLine = line;
			// System.out.println(line);
			int indexPart = line.indexOf("=");
			String firstPart;
			String secondPart;
			if (isMultipleLine) {
				firstPart = line;
				secondPart = "";
			} else {
				if (indexPart == -1) {
					firstPart = line;
					secondPart = "";
				} else {
					firstPart = line.substring(0, indexPart);
					secondPart = line.substring(indexPart + 1);
				}
			}

			// String[] array = line.split("=");
			if (isMultipleLine) {
				// buff.append("\n");
				value += firstPart + "\n";
			} else {
				// buff.append(array[0])
				//	.append("\n");
				key = firstPart;
				value += secondPart + "\n";
			}
			isMultipleLine = line.trim().endsWith("\\");
			if (!isMultipleLine) {
				// System.out.println(key + " " + value);
				map.put(key, value);
				key = "";
				value = "";
			}
			index++;
		}
		in.close();

		// System.out.println(map);

		File outputFile = new File("dest", fileName);
		FileOutputStream fos = new FileOutputStream(outputFile);
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(fos, "UTF-8"));
		// fos.write(buff.toString().getBytes("UTF-8"));
		for (Map.Entry<String, String> entry : map.entrySet()) {
			writer.print(entry.getKey() + "=" + entry.getValue());
		}
		writer.flush();
		writer.close();
	}
}
