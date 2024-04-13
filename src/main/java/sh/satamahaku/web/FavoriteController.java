package sh.satamahaku.web;

import org.h2.tools.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sh.satamahaku.domain.Harbour;
import sh.satamahaku.domain.HarbourRepository;
import sh.satamahaku.domain.User;
import sh.satamahaku.domain.UserRepository;

@Controller

public class FavoriteController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HarbourRepository harbourRepository;

    @Autowired
    UserDetailService userDetailService;


    @PostMapping("/savefavorite/{harbourid}")
    public String saveHarbourInFavourites(Model model, @PathVariable("harbourid") Long harbourid){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();

        Harbour harbour = harbourRepository.findById(harbourid).orElse(null);

        User user = userRepository.findByuserName(username);

        if (user.getFavoriteHarbours().contains(harbour)) {
            
            user.removeFavoriteHarbour(harbour);
        } else {
            
            user.addFavoriteHarbour(harbour);
        }

        userRepository.save(user);


        return "redirect:/harbourlist"; //harbourlist.html
    }

    @GetMapping("/favoriteharbours")
    public String favoriteHarboursPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();

        User user = userRepository.findByuserName(username);
        model.addAttribute("favoriteharbours", user.getFavoriteHarbours());

        return "favoriteharbours";
    }
}
