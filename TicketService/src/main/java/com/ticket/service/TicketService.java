package com.ticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.ticket.exception.TicketNotFoundException;
import com.ticket.model.Ticket;
import com.ticket.repository.TicketRepository;

@Service
public class TicketService {

	
	
	
	@Autowired
	private TicketRepository repository;
	
	
	
	public String saveTicket(Ticket ticket)
	{

		Ticket save = repository.save(ticket);
		if(!ObjectUtils.isEmpty(save))
		{
			return "Successfully ticket is booked";
			
		}
		else
		{
			return "Sorry ticket booing is failed";
			
		}	
		
	}
	 public Ticket findById(Integer ticketId)
	 {
		 return repository.findById(ticketId).orElseThrow(() -> new TicketNotFoundException("Ticket not Found Exception"));
	 }
	
	
	public Ticket getTicket(Integer ticketId)
	{
		
		return repository.findById(ticketId).get();
		
	}
	
	public String deleteTicket(Integer ticketId)
	{
		
	 repository.deleteById(ticketId);
	 return "Canceled Successfully";
		
	}
	
	
	
	
}
