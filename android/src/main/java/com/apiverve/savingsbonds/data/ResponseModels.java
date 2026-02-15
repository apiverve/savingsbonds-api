// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     SavingsBondsData data = Converter.fromJsonString(jsonString);

package com.apiverve.savingsbonds.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static SavingsBondsData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(SavingsBondsData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(SavingsBondsData.class);
        writer = mapper.writerFor(SavingsBondsData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// SavingsBondsData.java

package com.apiverve.savingsbonds.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;

public class SavingsBondsData {
    private IBonds iBonds;
    private EeBonds eeBonds;
    private String recommendation;
    private String recommendationReason;
    private LocalDate nextRateChange;
    private OffsetDateTime lastUpdated;

    @JsonProperty("iBonds")
    public IBonds getIBonds() { return iBonds; }
    @JsonProperty("iBonds")
    public void setIBonds(IBonds value) { this.iBonds = value; }

    @JsonProperty("eeBonds")
    public EeBonds getEeBonds() { return eeBonds; }
    @JsonProperty("eeBonds")
    public void setEeBonds(EeBonds value) { this.eeBonds = value; }

    @JsonProperty("recommendation")
    public String getRecommendation() { return recommendation; }
    @JsonProperty("recommendation")
    public void setRecommendation(String value) { this.recommendation = value; }

    @JsonProperty("recommendationReason")
    public String getRecommendationReason() { return recommendationReason; }
    @JsonProperty("recommendationReason")
    public void setRecommendationReason(String value) { this.recommendationReason = value; }

    @JsonProperty("nextRateChange")
    public LocalDate getNextRateChange() { return nextRateChange; }
    @JsonProperty("nextRateChange")
    public void setNextRateChange(LocalDate value) { this.nextRateChange = value; }

    @JsonProperty("lastUpdated")
    public OffsetDateTime getLastUpdated() { return lastUpdated; }
    @JsonProperty("lastUpdated")
    public void setLastUpdated(OffsetDateTime value) { this.lastUpdated = value; }
}

// EeBonds.java

package com.apiverve.savingsbonds.data;

import com.fasterxml.jackson.annotation.*;

public class EeBonds {
    private double currentRate;
    private String guaranteedDoubling;
    private long purchaseLimit;

    @JsonProperty("currentRate")
    public double getCurrentRate() { return currentRate; }
    @JsonProperty("currentRate")
    public void setCurrentRate(double value) { this.currentRate = value; }

    @JsonProperty("guaranteedDoubling")
    public String getGuaranteedDoubling() { return guaranteedDoubling; }
    @JsonProperty("guaranteedDoubling")
    public void setGuaranteedDoubling(String value) { this.guaranteedDoubling = value; }

    @JsonProperty("purchaseLimit")
    public long getPurchaseLimit() { return purchaseLimit; }
    @JsonProperty("purchaseLimit")
    public void setPurchaseLimit(long value) { this.purchaseLimit = value; }
}

// IBonds.java

package com.apiverve.savingsbonds.data;

import com.fasterxml.jackson.annotation.*;

public class IBonds {
    private double currentRate;
    private double fixedRate;
    private double inflationRate;
    private long purchaseLimit;

    @JsonProperty("currentRate")
    public double getCurrentRate() { return currentRate; }
    @JsonProperty("currentRate")
    public void setCurrentRate(double value) { this.currentRate = value; }

    @JsonProperty("fixedRate")
    public double getFixedRate() { return fixedRate; }
    @JsonProperty("fixedRate")
    public void setFixedRate(double value) { this.fixedRate = value; }

    @JsonProperty("inflationRate")
    public double getInflationRate() { return inflationRate; }
    @JsonProperty("inflationRate")
    public void setInflationRate(double value) { this.inflationRate = value; }

    @JsonProperty("purchaseLimit")
    public long getPurchaseLimit() { return purchaseLimit; }
    @JsonProperty("purchaseLimit")
    public void setPurchaseLimit(long value) { this.purchaseLimit = value; }
}