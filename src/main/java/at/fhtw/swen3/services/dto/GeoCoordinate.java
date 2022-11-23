package at.fhtw.swen3.services.dto;

import java.awt.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import javax.annotation.Generated;

/**
 * GeoCoordinate
 */

@JsonTypeName("geoCoordinate")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-18T12:42:11.503113Z[Etc/UTC]")
public class GeoCoordinate {

  @JsonProperty("lat")
  private Point lat;

  @JsonProperty("lon")
  private Point lon;

  public GeoCoordinate lat(Point lat) {
    this.lat = lat;
    return this;
  }

  /**
   * Latitude of the coordinate.
   * @return lat
  */
  @NotNull 
  @Schema(name = "lat", description = "Latitude of the coordinate.", required = true)
  public Point getLat() {
    return lat;
  }

  public void setLat(Point lat) {
    this.lat = lat;
  }

  public GeoCoordinate lon(Point lon) {
    this.lon = lon;
    return this;
  }

  /**
   * Longitude of the coordinate.
   * @return lon
  */
  @NotNull 
  @Schema(name = "lon", description = "Longitude of the coordinate.", required = true)
  public Point getLon() {
    return lon;
  }

  public void setLon(Point lon) {
    this.lon = lon;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeoCoordinate geoCoordinate = (GeoCoordinate) o;
    return Objects.equals(this.lat, geoCoordinate.lat) &&
        Objects.equals(this.lon, geoCoordinate.lon);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lat, lon);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeoCoordinate {\n");
    sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
    sb.append("    lon: ").append(toIndentedString(lon)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

