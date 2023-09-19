import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class JiraExporter {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClients.createDefault();
        String jiraUrl = "http://your-jira-instance/rest/api/2/search";
        String jql = "project=PROJECT_KEY AND status=STATUS";
        String completeUrl = jiraUrl + "?jql=" + jql;

        HttpGet request = new HttpGet(completeUrl);
        request.setHeader("Authorization", "Basic YOUR_BASE64_ENCODED_CREDENTIALS");

        try {
            HttpResponse response = httpClient.execute(request);
            String json = EntityUtils.toString(response.getEntity());
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
