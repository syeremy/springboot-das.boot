package com.syeremy.controller;

import com.syeremy.model.Shipwreck;
import com.syeremy.repository.ShipwreckRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by syeremy on 5/30/17.
 */

@RestController
@RequestMapping(value = "api/v1")
public class ShipwreckController {

    @Autowired
    private ShipwreckRepository shipwreckRepository;

    @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
    public List<Shipwreck> list()
    {
        return  shipwreckRepository.findAll();
    }

    @RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
    public Shipwreck create(@RequestBody Shipwreck shipwreck)
    {
        return  shipwreckRepository.saveAndFlush(shipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
    public Shipwreck get(@PathVariable long id)
    {
        return  shipwreckRepository.findOne(id);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
    public Shipwreck update(@PathVariable long id, @RequestBody Shipwreck shipwreck)
    {
        Shipwreck shipwreckCurrent = shipwreckRepository.findOne(id);
        BeanUtils.copyProperties(shipwreck, shipwreckCurrent);
        return  shipwreckRepository.saveAndFlush(shipwreckCurrent);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
    public Shipwreck delete(@PathVariable long id)
    {
        Shipwreck shipwreckCurrent = shipwreckRepository.findOne(id);
        shipwreckRepository.delete(shipwreckCurrent);

        return shipwreckCurrent;
    }
}
