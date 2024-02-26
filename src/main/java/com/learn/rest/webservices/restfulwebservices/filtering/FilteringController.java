package com.learn.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filter")
    public MappingJacksonValue testFilter() {
        FilterTest filterTest = new FilterTest("value1", "value2", "value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(filterTest);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value_1", "value_3");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("DynamicFilter", filter);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }

    @GetMapping("/filterList")
    public MappingJacksonValue testFilterList() {
        List<FilterTest> filterTests = Arrays.asList(new FilterTest("value1", "value2", "value3"), new FilterTest("value1", "value2", "value3"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(filterTests);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value_2","value_3");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("DynamicFilter", filter);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }
}
