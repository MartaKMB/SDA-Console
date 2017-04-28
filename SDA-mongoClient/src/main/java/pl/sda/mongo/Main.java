package pl.sda.mongo;

import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PostsDAO dao = new PostsDAO();

        Post post = new Post();
        post.setAuthor("Roman");
        post.setContent("ROMANSE");
        post.setDate(new Date());

        dao.insert(post);

        List<DBObject> result = dao.searchById(new ObjectId("58c04d41d5fb9a0d4004c757"));

        Post post2 = new Post();
        post2.setAuthor("Tadeusz");
        post2.setContent("Zaktualizowana tresc");
        post2.setDate(new Date());

        dao.updateById(post2, new ObjectId("58c040dd37ea1ff351b9336f"));

        DBObject dbObject = dao.removeById(new ObjectId("58c05091d5fb9a150c927d49"));

        System.out.println(dbObject);
    }
}
