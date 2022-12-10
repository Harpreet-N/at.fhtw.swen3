package at.fhtw.swen3.configuration;

import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.impl.ParcelServiceImpl;
import at.fhtw.swen3.services.impl.WarehouseServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ParcelServiceImpl parcelService(ParcelRepository parcelRepository) {
        return new ParcelServiceImpl(parcelRepository);
    }

    @Bean
    public WarehouseServiceImpl parcelService(WarehouseRepository warehouseRepository) {
        return new WarehouseServiceImpl(warehouseRepository);
    }

}
