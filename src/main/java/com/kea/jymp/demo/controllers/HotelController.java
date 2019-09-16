package com.kea.jymp.demo.controllers;

import com.kea.jymp.demo.models.Hotel;
import com.kea.jymp.demo.repositories.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HotelController {

    @Autowired
    private HotelRepo hotelRepo;

    @GetMapping ("/hotel")
    public String showAllHotels(Model model) throws Exception {
        List<Hotel> hotelList = hotelRepo.getAllHotels();
        model.addAttribute("hotel", hotelList);
        return "/hotel/hotel";
    }

    @GetMapping ("/hotel/delete-hotel/{id}")
    public String deleteHotel(@PathVariable("id") int id) throws Exception {
        hotelRepo.deleteHotel(id);
        return "redirect:/hotel";
    }

    @GetMapping("/hotel/add-hotel")
    public String addHotel(Model m) {
        m.addAttribute("newHotel", new Hotel());
        return "/hotel/add-hotel";
    }

    @PostMapping("/hotel/add-hotel/save")
    public String saveHotel(@ModelAttribute Hotel hotel, @ModelAttribute("a") String typeH) {
        hotelRepo.addHotel(hotel);
        return "redirect:/hotel";
    }

    @GetMapping("/hotel/edit-hotel/{id}")
    public String editHotel(@PathVariable("id") int id, Model model) {
        Hotel hotel = hotelRepo.findHotelById(id);
        model.addAttribute("editedHotel", hotel);
        return "/hotel/edit-hotel";
    }


    @PostMapping("/hotel/edit-hotel/save")
    public String saveEditedHotel(@ModelAttribute Hotel hotel){
        hotelRepo.editHotel(hotel);
        return "redirect:/hotel";
    }


}
