package pl.sda.mongo;

import com.mongodb.*;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

// klasa odwolujaca sie do bazy danych
// DAO - Data Access Object
// fasada na baze danych

public class PostsDAO {

    public WriteResult insert(Post post) {

//        tworzymy klienta do bazy
//        pobieramy baze danych

        DBCollection posts = getDbCollection();

//        mongo przechowuje jako json, zapewnia swoj wewnetrzny obiekt - opakowanie dla mapy

        BasicDBObject newPost = new BasicDBObject();

//        dodanie nowej wartosci dla klucza
        newPost.put("author", post.getAuthor());
        newPost.put("content", post.getContent());
        newPost.put("date", post.getDate());

        return posts.insert(newPost);
    }

//    metoda pobierajaca dane z bazy

    public List<DBObject> searchById(ObjectId id) {
        DBCollection posts = getDbCollection();

//        budujemy zapytanie, wiec tworzymy jsona z parametrem po ktorym szukamy

        BasicDBObject query = new BasicDBObject();
        query.put("_id", id);

//        metoda zwraca iterator, "db kursor"
//        zostaje zwrocona lista w obiekcie - nie pakuje wszystkiego do pamieci, tylko przeszukuje kolejno

        DBCursor postCursor = posts.find(query);

//        iterator po obiektach, w wyniku lista
//        DBObject to mapa

        List<DBObject> result = new ArrayList<>();
        while (postCursor.hasNext()) {
            DBObject post = postCursor.next();
            result.add(post);
        }
        return result;

    }

    public DBObject removeById(ObjectId id) {
        BasicDBObject query = new BasicDBObject();
        query.put("_id", id);

        DBCollection posts = getDbCollection();
        return posts.findAndRemove(query);
    }

    public WriteResult updateById (Post post, ObjectId id) {

//        budujemy json'a z danymi do wstawienia
//        pobieramy kolekcje

        DBCollection posts = getDbCollection();

        BasicDBObject query = new BasicDBObject();

//        tworzymy json'a wykorzystywanego do wyszukiwania

        query.put("_id", id);

//        budujemy obiekt dla update'a

        BasicDBObject updatedPost = new BasicDBObject();
        updatedPost.put("author", post.getAuthor());
        updatedPost.put("content", post.getContent());
        updatedPost.put("date", post.getDate());

//        po przypisaniu wartosci podajemy parametry
//        znajduje wszystkie obiekty z parametrem wejsciowym i zastepuje dane

        return posts.update(query, updatedPost);
    }

    private DBCollection getDbCollection() {
        Mongo mongoClient = new Mongo();

//        inna klasa pozwalajaca na dostep do mongo
//        MongoClient mongoClient = new MongoClient("localhost", 27017);

        return mongoClient.getDB("SDATest").getCollection("posts");
    }
}