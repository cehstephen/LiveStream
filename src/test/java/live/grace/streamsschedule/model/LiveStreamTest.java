package live.grace.streamsschedule.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LiveStreamTest {


    @Test
    void create_new_mutable_live_stream() {
        MutableLiveStream stream = new MutableLiveStream();
        stream.setId(UUID.randomUUID().toString());
        stream.setTitle("Building REST API with Spring boot");
        stream.setDescription("It's amazing how beautiful Spring boot is for building API solutions. I have got to explore and use Spring boot excellently.");
        stream.setUrl("https://www.grace.live");
        stream.setStartDate(LocalDateTime.of(2024,3,15,18,30) );
        stream.setEndDate(LocalDateTime.of(2024, 3,20,0,15));

        assertNotNull(stream);
        assertEquals("Building REST API with Spring boot", stream.getTitle());
    }


    @Test
    void create_new_immutable_live_stream(){
        ImmutableLiveStream stream = new ImmutableLiveStream(
                UUID.randomUUID().toString(),
                "Building REST API with Spring boot",
                "It's amazing how beautiful Spring boot is for building API solutions. I have got to explore and use Spring boot excellently.",
                "https://www.grace.live",
                LocalDateTime.of(2024,3,15,18,30 ),
                LocalDateTime.of(2024, 3,20,0,15)
        );

        assertNotNull(stream);
        assertEquals("Building REST API with Spring boot", stream.getTitle().toString());
    }

    @Test
    void create_new_record_live_stream(){
        LiveStream stream = new LiveStream(
                UUID.randomUUID().toString(),
                "Building REST API with Spring boot",
                "It's amazing how beautiful Spring boot is for building API solutions. I have got to explore and use Spring boot excellently.",
                "https://www.grace.live",
                LocalDateTime.of(2024,3,15,18,30 ),
                LocalDateTime.of(2024, 3,20,0,15)
        );

        assertNotNull(stream);
        assertEquals("Building REST API with Spring boot", stream.title());
        //assertTrue(stream.getClass().isRecord());
        assertEquals(6,stream.getClass().getRecordComponents().length);

    }

    @Test
    void name() {
    }
}