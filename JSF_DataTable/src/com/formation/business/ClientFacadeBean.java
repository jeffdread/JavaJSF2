package com.formation.business;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.formation.entity.*;;

@ManagedBean(name="facade")
@ApplicationScoped
public class ClientFacadeBean implements ClientFacade{
	private static List<Client> clients;
	private static int i=1;
	
	public Client createClient(Client client){
		client.setId(i++);
		clients.add(client);
		return client;
	}
	
	public List<Client> findClients(){
		return clients;
	}
	
	
	public void delete(Client client){
		/*client.remove(client);*/
	}
	
	@PostConstruct
	private void init(){
		clients = new ArrayList<Client>();
		clients.add(new Client(i++, "Didier", "Pelat"));
		clients.add(new Client(i++, "Laure", "Bourgeois"));
		clients.add(new Client(i++, "Sylvain", "Henry"));
		clients.add(new Client(i++, "Jim", "Alec"));
	}
	
	

}
