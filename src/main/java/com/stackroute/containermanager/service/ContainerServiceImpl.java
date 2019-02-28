package com.stackroute.containermanager.service;

import com.stackroute.containermanager.domain.Order;
import com.stackroute.containermanager.domain.Slot;
import com.stackroute.containermanager.domain.SlotAvailability;
import com.stackroute.containermanager.domain.SlotEvaluation;
import com.stackroute.containermanager.exception.OrderAlreadyExists;
import com.stackroute.containermanager.repository.ContainerRepository;
import com.stackroute.containermanager.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public class ContainerServiceImpl implements ContainerService
{
    private ContainerRepository containerRepository;
    private SlotRepository slotRepository;

    @Autowired
    public ContainerServiceImpl(ContainerRepository containerRepository)
    {
        this.containerRepository = containerRepository;
    }

    @Override
    public SlotEvaluation saveOrderAndGetSlots(Order order) throws OrderAlreadyExists
    {
        if(containerRepository.existsById(order.getResponseId()))
        {
            throw new OrderAlreadyExists("Order already exists");
        }
        Order savedOrder=containerRepository.save(order);
        if(savedOrder==null)
        {
            throw new OrderAlreadyExists();
        }

         return getSlot(order.getOrderDate());
//        return savedOrder;
        // getSlots();
    }
    public SlotEvaluation getSlot(Date date)
    {

        if(slotRepository.existsById(date))
        {
            Optional<SlotEvaluation> slotEvaluation=slotRepository.findById(date);
            List<SlotAvailability> slotAvailabilities=slotEvaluation.get().getSlotAvailabilities();
            for (SlotAvailability slotAvailability:slotAvailabilities) {
             slotAvailability.getSlots()   
            }

//            List<Slot> slots=slotAvailabilities.get().getSlots();
        }
    }
//    getSlots()
//    {
//
//    }

}
