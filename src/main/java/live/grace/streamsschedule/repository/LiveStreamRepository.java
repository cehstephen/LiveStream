package live.grace.streamsschedule.repository;

import live.grace.streamsschedule.model.LiveStream;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class LiveStreamRepository {

    List<LiveStream> streams = new ArrayList<>();

    public LiveStreamRepository(){
        LiveStream stream = new LiveStream(
                UUID.randomUUID().toString(),
                "Building REST API with Spring boot",
                "It's amazing how beautiful Spring boot is for building API solutions. I have got to explore and use Spring boot excellently.",
                "https://www.grace.live",
                LocalDateTime.of(2024,3,15,18,30 ),
                LocalDateTime.of(2024, 3,20,0,15)
        );

    }

    public List<LiveStream> findAll(){
        return streams;
    }

    public LiveStream findById(String id){
        return streams.stream().filter(stream -> stream.id().equals(id))
                .findFirst().orElse(null);
    }

    public LiveStream create(LiveStream stream){
        streams.add(stream);
        return stream;
    }

    public  void update(LiveStream stream, String id){
        LiveStream existing = streams.stream().filter(s -> s.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("stream not found"));

        int i = streams.indexOf(existing);
        streams.set(i, stream);
    }

    public void delete(String id){
        streams.removeIf(stream -> stream.id().equals(id));
    }
}
