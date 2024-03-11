package live.grace.streamsschedule.controller;

import jakarta.validation.Valid;
import live.grace.streamsschedule.model.LiveStream;
import live.grace.streamsschedule.repository.LiveStreamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {

    private final LiveStreamRepository repository;
    public LiveStreamController(LiveStreamRepository repository){
        this.repository = repository;
    }

    @GetMapping("/")
    public List<LiveStream> findAll(){

        return repository.findAll();
    }

    @GetMapping("/create")
    public String create(LiveStream stream){
        LiveStream streams = new LiveStream(
                UUID.randomUUID().toString(),
                "Building REST API with Spring boot",
                "It's amazing how beautiful Spring boot is for building API solutions. I have got to explore and use Spring boot excellently.",
                "https://www.grace.live",
                LocalDateTime.of(2024,3,15,18,30 ),
                LocalDateTime.of(2024, 3,20,0,15)
        );

        repository.create(streams);
        return "Created";
    }

    @GetMapping("/{id}")
    public LiveStream findById(@PathVariable String id){
        return repository.findById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        repository.delete(id);
        return "Details for ID: "+ id + " has been deleted.";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LiveStream apiCreate(@Valid @RequestBody LiveStream stream){
        return repository.create(stream);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    public void update(@RequestBody LiveStream stream, @PathVariable String id){
        repository.update(stream, id);
    }

}
