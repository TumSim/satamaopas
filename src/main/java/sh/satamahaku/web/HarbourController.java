package sh.satamahaku.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sh.satamahaku.domain.Harbour;
import sh.satamahaku.domain.HarbourRepository;
import sh.satamahaku.domain.HarbourType;
import sh.satamahaku.domain.HarbourTypeRepository;

@Controller

public class HarbourController {

    @Autowired
    HarbourRepository harbourRepository;

    @Autowired
    HarbourTypeRepository harbourTypeRepository;

    @GetMapping("/harbourlist") // Get all harbours for front page
    public String listOfHarbours(Model model){
        model.addAttribute("harbours", harbourRepository.findAll());
        return "harbourlist"; //harbourlist.html
    }


    @GetMapping("/detailharbourpage/{harbourid}")
    public String detailsPageOfOneHarbour(@PathVariable("harbourid") Long harbourid, Model model){
        Harbour harbour = harbourRepository.findById(harbourid).orElseThrow();
        model.addAttribute("harbourservices", harbour.getServices());
        model.addAttribute("harbourtype", harbour.getHarbourType());
        model.addAttribute("harbourid", harbour);

        return "detailharbourpage";
    }


}
