package at.fhtw.swen3.configuration;

import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.impl.ParcelServiceImpl;
import at.fhtw.swen3.services.impl.WarehouseServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ParcelService parcelService(ParcelRepository parcelRepository, GeoEncodingService geoEncodingService) {
        return new ParcelServiceImpl(parcelRepository, geoEncodingService);
    }

    @Bean
    public WarehouseService warehouseService(WarehouseRepository warehouseRepository) {
        return new WarehouseServiceImpl(warehouseRepository);
    }

}
