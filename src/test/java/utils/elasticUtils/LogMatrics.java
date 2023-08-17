package utils.elasticUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.search.MatchQuery;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;

import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

public class LogMatrics {
	private static Logger logger = Logger.getLogger(LogMatrics.class.getName());
	static Logger log = Logger.getLogger("");
	private String indexName;
	private String indexType;
	public int waitSeconds = 0;
	public static final String ELASTCSEARCH_CLOULD_INDEX_NAME = "mobifin_5x";
	public static final String ELASTCSEARCH_CLOULD_INDEX_TYPE = "doc";

	public LogMatrics() {

	}

	public LogMatrics(int waitSeconds) {
		this.waitSeconds = waitSeconds;
	}

	private String elastiUrl = "http://10.10.180.82:9200/apiexecution/matrics";

	public LogMatrics(String indexName, String indexType) {
		this.indexName = indexName;
		this.indexType = indexType;
	}

	public void logToElasticsearch(Map<Object, Object> elasticData) {
		try {
			if (elasticData != null && elasticData.size() > 0) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
				sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
				int value = (Integer) elasticData.get("Value");
				if (value == 100)
					elasticData.put("Automation Status", "Pass");
				else if (value == 50)
					elasticData.put("Automation Status", "Skip");
				else if (value == 0)
					elasticData.put("Automation Status", "Fail");
				elasticData.put("timeStamp", sdf.format(new Date()));
				Gson gson = new Gson();
				Client client = ClientBuilder.newClient();
				WebTarget webTarget = null;
				if (this.indexName != null && this.indexType != null) {
					webTarget = client.target("http://192.168.33.214:9200/" + this.indexName + "/" + this.indexType);
				} else {
					webTarget = client.target(elastiUrl);
				}

				String temp = gson.toJson(elasticData);
				String logData = "[" + elasticData.get("timeStamp") + "] " + temp;
				log.info("[INFO] " + logData);
				Response response = webTarget.request().post(Entity.entity(temp, MediaType.APPLICATION_JSON),
						Response.class);
				logger.info("Response: " + response.toString());
			}
		} catch (Exception ex) {
			logger.log(Level.WARNING, "Exception in logToElasticsearch method", ex);
			ex.printStackTrace();
		}
	}

	public static String getTaskName(String taskName) {
		try {
			if (taskName != null) {
				SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
				searchSourceBuilder.from(0);
				searchSourceBuilder.size(10000);
				searchSourceBuilder.query(
						QueryBuilders.multiMatchQuery(taskName, "Task Name").type(MatchQuery.Type.PHRASE_PREFIX));
				Search search = ElasticUtils.getSearchObject(searchSourceBuilder, ELASTCSEARCH_CLOULD_INDEX_NAME,
						ELASTCSEARCH_CLOULD_INDEX_TYPE);

				SearchResult result = ElasticUtils.executeSearch(search);
				Set<String> tasks = new HashSet<String>();

				if (result != null) {
					JSONArray js = (new JSONObject(result.getJsonString()).getJSONObject("hits")).getJSONArray("hits");
					for (int i = 0; i < js.length(); i++) {
						JSONObject srcObj = js.getJSONObject(i);
						tasks.add(srcObj.getJSONObject("_source").getString("Task Name"));
					}
				}

				for (String s : tasks) {
					System.out.println(s.trim());
				}
				if (tasks.size() > 0) {
					return taskName + "_" + tasks.size();
				}
			}

		} catch (Exception e) {
		}
		return taskName;
	}

	public static void main(String[] args)
			throws InterruptedException, JsonParseException, JsonMappingException, IOException {
		LogMatrics logMatrics = new LogMatrics("testkibana", "docs");
		Map<Object, Object> map = new HashMap<>();
		map.put("UserName", "Dishant");
		map.put("value", 0);
		logMatrics.logToElasticsearch(map);
	}
}
