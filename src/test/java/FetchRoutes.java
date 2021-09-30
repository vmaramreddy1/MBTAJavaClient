import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.vmaramreddy.models.Routes;
import org.vmaramreddy.rest.HttpClientRestClient;
import org.vmaramreddy.rest.RestResponse;
import org.vmaramreddy.rest.configuration.BasicConfiguration;
import org.vmaramreddy.rest.configuration.Configuration;
import org.vmaramreddy.rest.request.GetRequest;
import org.vmaramreddy.rest.request.Request;
import org.vmaramreddy.rest.request.body.NoBodyContent;
import org.vmaramreddy.rest.request.body.RequestBodyContent;

import java.io.IOException;

public class FetchRoutes {

    @Test
    public void testFetchRoutes() throws JsonProcessingException {
        // Create client
        final Configuration configuration = new BasicConfiguration("https://api-v3.mbta.com");
        final HttpClientRestClient restClient = new HttpClientRestClient();
        restClient.init(configuration);

        //Make Get Request
        final Request<String> commuterRailRequest = new GetRequest<String>() {
            @Override
            public String getApiEndpoint() {
                return "/routes?filter[type]=2";
            }

            @Override
            public RequestBodyContent getRequestBody() {
                return NoBodyContent.INSTANCE;
            }

            @Override
            public String parseResponse(final String responseStr) throws IOException {
              return responseStr;
            }
        };
        final RestResponse result = restClient.submitRequest(commuterRailRequest);
        ObjectMapper mapper = new ObjectMapper();
        Routes routes = mapper.readValue(result.getResponseStr(), Routes.class);
        routes.data.stream().forEach(route -> System.out.println(route.attributes.long_name));

    }

    @Test
    public void listTheStops() throws JsonProcessingException {
        // Create client
        final Configuration configuration = new BasicConfiguration("https://api-v3.mbta.com");
        final HttpClientRestClient restClient = new HttpClientRestClient();
        restClient.init(configuration);

        //Make Get Request
        final Request<String> commuterRailRequest = new GetRequest<String>() {
            @Override
            public String getApiEndpoint() {
                return "/routes?filter[stop]=Framingham%2FWorcester%20Line";
            }

            @Override
            public RequestBodyContent getRequestBody() {
                return NoBodyContent.INSTANCE;
            }

            @Override
            public String parseResponse(final String responseStr) throws IOException {
                return responseStr;
            }
        };
        final RestResponse result = restClient.submitRequest(commuterRailRequest);
        ObjectMapper mapper = new ObjectMapper();
        Routes routes = mapper.readValue(result.getResponseStr(), Routes.class);
        routes.data.stream().forEach(route -> System.out.println(route.attributes.long_name));
    }

}
