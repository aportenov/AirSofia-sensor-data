package com.parser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class HomeController {

    @Value("${locationiq.keys}")
    private String[] keys;

    @GetMapping(value = "/seonsor-data", produces = MediaType.APPLICATION_JSON_VALUE) 
    public List<Wrapper> get() {
	
	List<Wrapper> stations = new ArrayList<>();
	List<Wrapper> wrapper = WebClient.create("http://api.luftdaten.info/static/v1/data.json")
		.get()
		.accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(Wrapper.class)
		.filter(location -> location.getLocation().getCountry().equalsIgnoreCase("BG"))
		.collectList()
		.block();

	wrapper.stream().limit(10).forEach(e -> {
	    try {
		LocationWraper address = WebClient.create(String.format(
        			"https://eu1.locationiq.com/v1/reverse.php?key=%s&lat=%sd&lon=%s&format=json",
        			this.keys[0],
        			e.getLocation().getLatitude(), 
        			e.getLocation().getLongitude())
			).get()
			.accept(MediaType.APPLICATION_JSON_UTF8).retrieve().bodyToMono(LocationWraper.class).block();

		String displayName = address.getDisplayName();
		if (displayName.indexOf("Sofia") > -1) {

		    int startIndex = displayName.indexOf(",");
		    e.setName(displayName.substring(startIndex + 1, displayName.indexOf(",", startIndex + 1)).trim());
		    stations.add(e);
		}

		Thread.sleep(1000);

	    } catch (InterruptedException e1) {
		e1.printStackTrace();
	    }
	});

	return stations;
    }

}
