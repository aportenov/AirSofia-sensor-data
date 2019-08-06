package com.parser;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.parse.models.LocationWraper;
import com.parse.models.Wrapper;

import reactor.core.publisher.Flux;

@RestController
public class HomeController {

    private static final String LUFTDATEN_URL = "http://api.luftdaten.info/static/v1/data.json";
    private static final String BG = "BG";
    private static final String LOCATIONIQ_URL =  "https://eu1.locationiq.com/v1/reverse.php?key=5c78fb00c549f2&lat=%sd&lon=%s&format=json";
    private static final String TOWN_INDEX = "Sofia";
    private static final String COMMA_SEPARATOR = ",";
    
    
    
    @Value("${locationiq.keys}")
    private String[] keys;

    private DataRepostiroy dataRepository;

    public HomeController(DataRepostiroy dataRepository) {
	this.dataRepository = dataRepository;
    }

    @GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Wrapper> get() {

	return WebClient.create(LUFTDATEN_URL)
		.get()
		.accept(MediaType.APPLICATION_JSON)
		.retrieve()
		.bodyToFlux(Wrapper.class)
		.filter(location -> location.getLocation().getCountry().equalsIgnoreCase(BG))
		.limitRequest(10)
		.delayElements(Duration.ofMillis(1000))
		.doOnNext(wrapper -> {
		    WebClient.create(String.format(
			    LOCATIONIQ_URL,
			    wrapper.getLocation().getLatitude(), wrapper.getLocation().getLongitude()))
		    .get()
			    .accept(MediaType.APPLICATION_JSON_UTF8)
			    .retrieve()
			    .bodyToMono(LocationWraper.class)
			    .subscribe(lw -> {

				String displayName = lw.getDisplayName();
				if (displayName.indexOf(TOWN_INDEX) > -1) {

				    int startIndex = displayName.indexOf(COMMA_SEPARATOR);
				    wrapper.setName(displayName
					    .substring(startIndex + 1, displayName.indexOf(COMMA_SEPARATOR, startIndex + 1))
					    .trim());

				}
				
				this.dataRepository.save(wrapper).subscribe();
			    });
		});
    }
}
