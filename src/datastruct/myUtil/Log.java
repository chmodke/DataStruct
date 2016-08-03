package datastruct.myUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
	private static File file;
	private static SimpleDateFormat sdf;
	static {
		file = new File("error.log");
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	public static void logOut(String log) {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("创建日志文件失败！！！");
			}
		}
		OutputStreamWriter osw = null;
		try {
			FileOutputStream fos = new FileOutputStream(file, true);
			osw = new OutputStreamWriter(fos);
			Date time = new Date();
			osw.write(sdf.format(time) + " " + log + '\n');
			time = null;
			log = null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("创建输出流失败！！！");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("写出日志失败！！！");
		} finally {
			try {
				osw.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("关闭输出流失败！！！");
			}
		}
	}
}
