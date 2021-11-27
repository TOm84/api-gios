package akademia.utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
public class ConnectionUtils {

  public HttpResponse getHttpResponse(String url) {
    HttpGet httpGet = new HttpGet(url);
    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpResponse httpResponse;
    try {
      httpResponse = httpClient.execute(httpGet);
    } catch (IOException e) {
      System.err.println(e.getMessage());
      return null;
    }
    int statusCode = httpResponse.getStatusLine().getStatusCode();
    if(statusCode != 200) {
      System.err.println("error status code");
      return null;
    }
//    if(statusCode == 503) {
//      System.err.println("Error 503 - Usługa niedostępna – serwer nie jest w stanie w danej chwili zrealizować zapytania klienta ze względu na przeciążenie ");
//      return null;
//    }
    return httpResponse;
  }

  public String getBodyFromResponse(HttpResponse httpResponse) {
    String responseBody;

    try(InputStream inputStream = httpResponse.getEntity().getContent()) {
      responseBody = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
    } catch(IOException e) {
      return null;
    }
    return responseBody;
  }

  public String getBodyWithHttpResponse(String url) {
    return getBodyFromResponse(getHttpResponse(url));
  }

}
