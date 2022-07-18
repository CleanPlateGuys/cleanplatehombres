package cleanplate.cleanplatehombres.Controllers;

import cleanplate.cleanplatehombres.Repositories.ListingRepository;
import cleanplate.cleanplatehombres.models.Listing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ListingController {

    private final ListingRepository listingRepository;

    public ListingController(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }


    //listing index controller
    @GetMapping("/listings")
    public String index(Model model) {
        model.addAttribute("listings", listingRepository.findAll());
        return "listings/listings";
    }


   //create controller
    @GetMapping("/listings/create")
    public String create(Model model) {
        model.addAttribute("listing", new Listing());
            return "listings/create";
    }

    @PostMapping("listings/create")
    public String post(@ModelAttribute Listing listing) {
        if(listing.getFoodName().equals("") || listing.getDonationDescription().equals("")){
            return "listings/create";
        }

        listingRepository.save(listing);
        return "redirect:/listings";
    }

   //show controller:
    @GetMapping("listings/show")
    public String showPage() {
        return "listings/show";
    }

    //edit controllerid
    @GetMapping("listings/edit/{id}")
    public String editListing(@PathVariable Integer id, Model model) {
        model.addAttribute("listing", listingRepository.getById(id));
        return "listings/edit";
    }

    @PostMapping("listings/edit")
   public String editListing(@ModelAttribute Listing listing){
        listingRepository.save(listing);
        return "redirect:/listings";
    }

    @GetMapping("listings/delete/{id}")
    public String delete(@ModelAttribute Listing listing) {
       listingRepository.delete(listing);
        return "redirect:/listings";
    }


}
