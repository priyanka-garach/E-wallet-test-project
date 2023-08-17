package utils.elasticUtils;

//import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.elasticsearch.search.builder.SearchSourceBuilder;

import bsh.This;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

public class ElasticUtils {
	public static final String ELASTIC_SEARCH_CLOUD_BASE_URL = "http://192.168.33.214:9200/";
	public static final int DEFAULT_MAX_TOTAL_CONNECTION_PER_ROUTE = 2;
	public static final int MAX_TOTAL_CONNECTION = 20;

	private static JestClientFactory jestClientFactory = null;
	private static JestClient jestClient = null;
	public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

	private static Logger logger = Logger.getLogger(ElasticUtils.class.getName());

	/**
	 * @see This method will return JestClient of base of given elastic search cloud
	 *      url
	 * @return JestClient
	 */
	public static JestClient getConnection() {
		if (jestClient == null) {
			jestClientFactory = new JestClientFactory();
			jestClientFactory
					.setHttpClientConfig(new HttpClientConfig.Builder(ELASTIC_SEARCH_CLOUD_BASE_URL).multiThreaded(true)
							// Per default this implementation will create no more than 2 concurrent
							// connections per given route
							.defaultMaxTotalConnectionPerRoute(DEFAULT_MAX_TOTAL_CONNECTION_PER_ROUTE)
							// and no more 20 connections in total
							.maxTotalConnection(MAX_TOTAL_CONNECTION).build());
			jestClient = jestClientFactory.getObject();
		}
		return jestClient;
	}

	/**
	 * @param searchSourceBuilder
	 * @param elastcSearchClouldIndexName
	 * @param elastcSearchClouldIndexType
	 * @see this method is used to create Search from given SearchSourceBuilder,
	 *      index name and index type
	 * @return Search
	 */
	public static Search getSearchObject(SearchSourceBuilder searchSourceBuilder, String elastcSearchClouldIndexName,
			String elastcSearchClouldIndexType) {
		if (searchSourceBuilder != null && elastcSearchClouldIndexName != null && elastcSearchClouldIndexType != null) {
			return (Search) new Search.Builder(searchSourceBuilder.toString()).addIndex(elastcSearchClouldIndexName)
					.addType(elastcSearchClouldIndexType).build();
		}
		return null;
	}

	/**
	 * @param search
	 * @see this method is used to execute given Search on elastic connection
	 * @return SearchResult
	 */
	public static SearchResult executeSearch(Search search) {
		try {
			JestClient client = ElasticUtils.getConnection();
			return client.execute(search);
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception occured in executeSearch", e);
		}
		return null;
	}
}
