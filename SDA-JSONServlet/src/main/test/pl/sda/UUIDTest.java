package pl.sda;

import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class UUIDTest {

    @Test
    public void test() {
        UUID id = UUID.randomUUID();

        String uuid = id.toString();

        UUID uuid2 = UUID.fromString(uuid);

        Assert.assertEquals(id, uuid2);
    }
}
