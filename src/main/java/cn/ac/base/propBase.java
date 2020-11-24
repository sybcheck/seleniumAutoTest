package cn.ac.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class propBase {
	public static Properties prop;
	public static final Logger LOGGER = LoggerFactory.getLogger(propBase.class);

	public propBase() {
		if (prop != null) {
			return;
		}
		// 加载配置文件
		LOGGER.info("初始化配置文件...");
		try {
			prop = new Properties();
			prop.load(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("config.properties"),
					"utf-8"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
