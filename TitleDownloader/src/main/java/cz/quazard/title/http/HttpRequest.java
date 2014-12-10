package cz.quazard.title.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HttpRequest {

	private static final Logger log = Logger.getLogger(HttpRequest.class);

	public static HttpResponse getRequest(String url) {
		HttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		try {
			return httpclient.execute(httpget);
		} catch (IOException e) {
			log.error("GET request error to url: " + url, e);
			return null;
		}
	}

	public static HttpResponse postRequest(String url,
			List<NameValuePair> params) {
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url);
		try {
			if (params != null)
				httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			return httpclient.execute(httppost);
		} catch (IOException e) {
			log.error("POST request error to url: " + url, e);
			return null;
		}
	}

	public static void main(String[] args) throws ClientProtocolException,
			IOException {
		HttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(
				"http://www.titulky.com/index.php?Fulltext=Sleepy+Hollow+S01E07");

		// Execute and get the response.
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();

		StringBuilder htmlPage = new StringBuilder();

		if (entity != null) {
			InputStream instream = entity.getContent();
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(
						instream));
				String inputLine;

				while ((inputLine = in.readLine()) != null) {
					System.out.println(inputLine);
					htmlPage.append(inputLine);
				}
				in.close();
			} finally {
				instream.close();
			}
		}

		Document doc = Jsoup.parse(htmlPage.toString());
		Elements links = doc.select("a");
		for (Iterator iterator = links.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			System.out.println("A:[" + element.text() + "]["
					+ element.attr("href") + "]");
		}
	}
}
