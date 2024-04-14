package sh.satamahaku.web;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import sh.satamahaku.domain.Harbour;
import sh.satamahaku.domain.HarbourRepository;
import sh.satamahaku.domain.HarbourType;
import sh.satamahaku.domain.HarbourTypeRepository;
import sh.satamahaku.domain.Service;
import sh.satamahaku.domain.ServiceRepository;
import sh.satamahaku.domain.User;
import sh.satamahaku.domain.UserRepository;

@Controller

public class HarbourController {

    @Autowired
    HarbourRepository harbourRepository;

    @Autowired
    HarbourTypeRepository harbourTypeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @GetMapping("/harbourlist") // Get all harbours for front page
    public String listOfHarbours(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();

        User user = userRepository.findByuserName(username);

        model.addAttribute("harbours", harbourRepository.findAll());
        model.addAttribute("viceversa", user.getFavoriteHarbours());
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

    @GetMapping("/newharbour")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String makeNewHarbour(Model model){
        model.addAttribute("newharbour", new Harbour());
        model.addAttribute("harbourtypes", harbourTypeRepository.findAll());
        model.addAttribute("services", serviceRepository.findAll());
        return "newharbour";
    }

    @PostMapping("/savenewharbour")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveNewHarbour(@ModelAttribute Harbour harbour, @RequestParam(value = "selectedServices", required = false) List<Long> selectedServices){
        harbourRepository.save(harbour);
        if (selectedServices != null) {
            for(Long serviceId : selectedServices){
                Service service = serviceRepository.findById(serviceId).orElse(null);
                if (service != null) {
                    service.addHarbours(harbour);
                    serviceRepository.save(service);
                }
            }
        }
        harbourRepository.save(harbour);
        return "redirect:/harbourlist";
    }


}
