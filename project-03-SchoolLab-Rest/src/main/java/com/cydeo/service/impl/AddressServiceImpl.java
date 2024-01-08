package com.cydeo.service.impl;

import com.cydeo.client.CountryClient;
import com.cydeo.client.WeatherClient;
import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.WeatherStack;
import com.cydeo.dto.country.Country;
import com.cydeo.entity.Address;
import com.cydeo.exception.NotFoundException;
import com.cydeo.util.MapperUtil;
import com.cydeo.repository.AddressRepository;
import com.cydeo.service.AddressService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Value("${access_key}")
    private String access_key;
    private final WeatherClient weatherClient;
    private final CountryClient countryClient;
    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;

    public AddressServiceImpl(WeatherClient weatherClient, CountryClient countryClient, AddressRepository addressRepository, MapperUtil mapperUtil) {
        this.weatherClient = weatherClient;
        this.countryClient = countryClient;
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<AddressDTO> findAll() {
        return addressRepository.findAll()
                .stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO findById(Long id) throws Exception {
        Address foundAddress = addressRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No Address Found!"));
        AddressDTO addressDTO = mapperUtil.convert(foundAddress, new AddressDTO());
        addressDTO.setCurrentTemperature(getCurrentTemperature(addressDTO.getCity()));
        String countryFlags = getCountryFlags(addressDTO.getCountry());
        addressDTO.setFlagPngUrl(countryFlags);
        return addressDTO;
    }

    String getCountryFlags(String country){
        Country[] countries = countryClient.getFlags(country);
        if (countries[0] == null || countries[0].flags == null) {
            return null;
        }
       return countries[0].flags.png;
    }

    Integer getCurrentTemperature(String city){
        WeatherStack weatherStack = weatherClient.getCurrentTemperature(access_key, city);
        if(weatherStack == null || weatherStack.current == null) {
            return null;
        }
        return weatherStack.current.temperature;
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) throws Exception {

        addressRepository.findById(addressDTO.getId())
                .orElseThrow(() -> new Exception("No Address Found!"));

        Address addressToSave = mapperUtil.convert(addressDTO, new Address());

        addressRepository.save(addressToSave);

        return mapperUtil.convert(addressToSave, new AddressDTO());

    }

    @Override
    public AddressDTO create(AddressDTO addressDTO) throws Exception {

        Optional<Address> foundAddress = addressRepository.findById(addressDTO.getId());

        if (foundAddress.isPresent()) {
            throw new Exception("Address Already Exists!");
        }

        Address addressToSave = mapperUtil.convert(addressDTO, new Address());

        addressRepository.save(addressToSave);

        return mapperUtil.convert(addressToSave, new AddressDTO());

    }

}