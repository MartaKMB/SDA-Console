package pl.sdaPostman;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import pl.sda.utils.HttpUtils;

import java.io.IOException;

public class Sender {

// klasa typu fasada na nowego klienta

    public static String createUser(String url, String request) throws IOException {

//        DefaultHttpClient() a kolejny wybor to closable
//        ostatecznie HttpClientBuilder
//        skreslony, bo wychodzi ze sprzedazy, zeby nie bylo skreslone, adnotacja powyzej
//        towrzymy klienta

        HttpClient httpClient = HttpClientBuilder.create().build();

//        tworzymy obiekt klasy Http post

        HttpPost post = new HttpPost(url);

//        tworzymy entities, body postmana
//        obiekt opakowujacy zwyklego stringa, aby klient mogl wyslac przez http

        post.setEntity(new StringEntity(request));

//        mamy post i obiekt klienta
//        na obiekcie klienta execute i podajemy post jako parametr, w wyniku obiekt http response

        HttpResponse response = httpClient.execute(post);

//        przepuszczamy przez utila i dostajemy stringa z json'em

        return HttpUtils.parseResponse(response);
    }

    public static String getUser(String url, String id) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(url + "?id=" + id);

        HttpResponse response = httpClient.execute(get);
        return HttpUtils.parseResponse(response);
    }
}
