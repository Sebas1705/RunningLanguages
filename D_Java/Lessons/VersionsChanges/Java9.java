package VersionsChanges;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Java9 {
    
    public static void main(String[] args) {
        try {
            exampleHttp2();
        } catch (IOException | InterruptedException | URISyntaxException e) {
            System.out.println(e.getMessage());
        }
    }

    static interface ExamplePrivateMethodsInterfaces{
        default void doSomething(){
            helper();
        }
        private void helper(){
            System.out.println("thing");
        }
    }

    public static void exampleHttp2() throws IOException, InterruptedException, URISyntaxException{
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://www.example.com"))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
