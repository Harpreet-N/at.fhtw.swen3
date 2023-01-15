package at.fhtw.swen3.configuration;

import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.gps.service.impl.GeoEncodingServiceImpl;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.impl.ParcelServiceImpl;
import at.fhtw.swen3.services.impl.WarehouseServiceImpl;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public ParcelService parcelService(ParcelRepository parcelRepository, HopRepository hopRepository, GeoEncodingService geoEncodingService) {
        return new ParcelServiceImpl(parcelRepository, hopRepository, geoEncodingService);
    }

    @Bean
    public WarehouseService warehouseService(WarehouseRepository warehouseRepository, HopRepository hopRepository) {
        return new WarehouseServiceImpl(warehouseRepository, hopRepository);
    }

    @Bean
    public RestTemplateBuilder restTemplateBuilder() {
        return new RestTemplateBuilder();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public GeoEncodingService geoEncodingService(RestTemplate restTemplate) {
        return new GeoEncodingServiceImpl(restTemplate);
    }

}
