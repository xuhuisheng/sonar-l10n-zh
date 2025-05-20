
package demo;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.text.*;
import java.util.*;
import javax.script.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.util.JSONPObject;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainTest {
	Logger log = LoggerFactory.getLogger(MainTest.class);
    static ObjectMapper mapper;

    @BeforeAll
    static void init() {
        mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

	@Test
	public void testDefault() throws Exception {
		log.info("start");

		String defaultMessages = readDefaultMessages();
		// log.info("defaultMessages : {}", defaultMessages);

		// Files.write(Paths.get("target/default.ts"), defaultMessages.getBytes(StandardCharsets.UTF_8));
  		int startIndex = defaultMessages.indexOf("export const defaultMessages = ");
  		int endIndex = defaultMessages.lastIndexOf(';');
  		String content = defaultMessages.substring(startIndex + 31, endIndex);
		log.info("defaultMessages : {}", content);

		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByExtension("js");
		Map<String, Object> result = (Map<String, Object>) engine.eval("(" + content + ")");
		// log.info("result : {}", result);

		StringBuilder buff = new StringBuilder();
		for (Map.Entry<String, Object> entry : result.entrySet()) {
			// log.info("entry : {}", entry);
			buff.append(entry.getKey() + "=" + entry.getValue() + "\n");
		}
		Files.write(Paths.get("target/core.properties"), buff.toString().getBytes(StandardCharsets.UTF_8));

		log.info("end");
	}

	String readDefaultMessages() throws Exception {
		byte[] bytes = Files.readAllBytes(Paths.get("/home/work/Downloads/sonarqube-25.2.0.102705/web/js/main-DFHP3MKj.js.map"));
		Map<String, Object> map = mapper.readValue(new String(bytes, StandardCharsets.UTF_8), Map.class);
		List<String> sources = (List<String>) map.get("sources");
		log.info("sources : {}", sources);
		int index = sources.indexOf("../../../src/main/js/l10n/default.ts");
		List<String> sourcesContent = (List<String>) map.get("sourcesContent");
		return sourcesContent.get(index);
	}

}
