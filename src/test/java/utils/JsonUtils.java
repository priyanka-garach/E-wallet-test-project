package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	public static String readJson(String fileName) {
		Path path = Paths.get(fileName);
		StringBuffer sb = new StringBuffer();
		try (Scanner scanner = new Scanner(path)) {
			while (scanner.hasNextLine()) {
				sb.append(scanner.nextLine().trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(sb);
	}

	public static void main(String[] args) {
//		String string = readJson("./test_data/json/cashIn.json");
//		System.out.println(string);
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("key1", "value1");
			jsonObject.put("key2", "value2");
			jsonObject.put("key3", "value3");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		createJsonFile("1A.json", jsonObject);
		// String jsonString =
		// readJson("C:\\Users\\badal.gandhi\\Desktop\\Dishant\\1A.json");
		// String str="";
		// try {
		// str = new JSONObject(jsonString).get("key2").toString();
		// } catch (JSONException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println(str);
	}

	public static void createJsonFile(String fileName, JSONObject jsonObject) {
		try {
			FileWriter file = new FileWriter(fileName);
			file.write(jsonObject.toString());
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getJsonFromMap(Map<Object, Object> map) {
		String json_string = "";
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			json_string = objectMapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json_string;
	}

}