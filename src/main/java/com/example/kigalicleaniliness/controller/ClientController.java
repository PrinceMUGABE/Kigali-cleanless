package com.example.kigalicleaniliness.controller;

import com.example.kigalicleaniliness.model.ClientModel;
import com.example.kigalicleaniliness.serviceImplementation.ClientServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    ClientServiceImplementation clientService;

    @GetMapping("/client/list")
       public String showClientList(Model model){
        List<ClientModel> listClient = clientService.displayClients();
        model.addAttribute("listClient", listClient);
           return "listClientPage";
        }

        @GetMapping("/client/new")
    public String showClientForm(Model model){
         ClientModel client = new ClientModel();
         model.addAttribute("client", client);
         model.addAttribute("pageTitle", "Client Form");
        return "saveClientPage";
        }

        @PostMapping("/client/save")
    public String saveClient(ClientModel client, RedirectAttributes ra){
         try{
             clientService.saveClient(client);
             ra.addFlashAttribute("message", "client saved successfully");
         }catch (Exception ex){
             ex.printStackTrace();
         }
        return "redirect:/client/list";
        }

        @GetMapping("/client/edit/{id}")
    public String editClient(@PathVariable("id") int id, Model model, RedirectAttributes ra){

        try {
            ClientModel savedClient = clientService.findClientById(id);
            model.addAttribute("client", savedClient);
            model.addAttribute("pageTitle", "edit client (ID: "+id+")");
            ra.addFlashAttribute("message","client updated successfully");
        }catch (Exception e){
            e.printStackTrace();
        }


        return "saveClientPage";
        }

        @GetMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable("id") int id, Model model, RedirectAttributes ra){
        try {
            clientService.deleteClient(id);
            ra.addFlashAttribute("message", "Client successfully deleted");
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/client/list";
        }
    }
